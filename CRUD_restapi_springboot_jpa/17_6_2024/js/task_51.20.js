/**REGION 1 */

const gREQUEST_STATUS_OK = 200;
const gREQUEST_CREATE_OK = 201; // status 201 là tạo mới thành công
const gREQUEST_READY_STATUS_FINISH_AND_OK = 4;
const gCONTENT_TYPE = "application/json;charset=UTF-8";

const gBASE_URL = "http://localhost:8088/api/";

var vBASE_URL_PROVINCE = gBASE_URL + "province/all";
var gProvinceIdToDelete = 0;
var gProvinceId = 0;
var vNumberical = 1;
var vCreatedProvinceId = 0;
var vCreatedDistrictId = 0;

var gProvinceNameInputElement = $("#input-province-name");
var gDistrictNameSelectElement = $("#district-name-select");
var gWardSelectElement = $("#ward-name-select");

var vLIST_PROVINCE_COL = ["id", "name", "code", "action"];

const gLIST_NUMBERIAL_COL = 0;
const gLIST_NAME_COL = 1;
const gLIST_CODE_COL = 2;
const gLIST_ACTION_COL = 3;

//Khai bao DataTable % mapping columns
var vListProvinceTable = $("#list-province-table").DataTable({

    columns: [
        { data: vLIST_PROVINCE_COL[gLIST_NUMBERIAL_COL] },
        { data: vLIST_PROVINCE_COL[gLIST_NAME_COL] },
        { data: vLIST_PROVINCE_COL[gLIST_CODE_COL] },
        { data: vLIST_PROVINCE_COL[gLIST_ACTION_COL] },
    ],

    columnDefs: [

        {
            targets: gLIST_NUMBERIAL_COL,
            render: function () {
                return vNumberical++;
            }
        },

        {
            targets: gLIST_ACTION_COL,
            defaultContent: `
            <div class="action-btn">
                <button class="icon-button col-11 bg-success edit-pet">
                    <i class="fas fa-pen-to-square"></i>
                </button>
                <button class="icon-button col-11 bg-danger delete-province">
                    <i class="far fa-trash-can"></i>
                </button>
            </div>
         `
        },

    ],
});

/**REGION 2 */

$(document).ready(function () {
    onPageLoading();
});

$("#list-province-table").on("click", "tr", function () {
    const provinceId = vListProvinceTable.row(this).data().id;
    getProvinceById(provinceId)
});


$('#create-listProvince-modal').submit(function (event) {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của form submittion
    // Thực hiện các xử lý khác, ví dụ gửi AJAX request
});

//gan su kien create 1 pet
$("#btn-add-province").on("click", function () {
    onBtnAddNewProvinceClick(this);
    console.log("Nut them province")
});

//gan su kien create pet tren modal
$("#btn-create-newProvince").on('click', function () {
    console.log("Create Province Now")
    onBtnCreateNewProvinceNowOnModalClick();
});

$("#btn-create-newDistrict").on('click', function () {
    console.log("Create District Now")
    createNewDistrictByProvinceId(vCreatedProvinceId);
});


$("#btn-create-newWard").on('click', function () {
    console.log("Create Ward Now")
    createNewWardByDistrictId(vCreatedDistrictId);
});




//Gan su kien Update Pet
$("#list-pets-table").on("click", ".edit-pet", function () {
    onBtnEditPetClick(this);
});
//Gan su kien update course MODAL
$("#btn-update-pet").on("click", function () {
    onBtnUpdatePetModalClick();
});


//Gan su kien Delete Pet
$("#list-province-table").on("click", ".delete-province", function () {
    onBtnDeleteProvineClick(this);
});
//gan su kien confirm delete
$("#btn-confirm-delete-course").on("click", function () {
    onBtnConfirmDeleteModal();
})

/**REGION 3 */

//Ham onPageLoading
function onPageLoading() {
    getAllProvince();
}


//Ham xu ly su kien khi nhan nut create 1 pet
function onBtnAddNewProvinceClick() {
    $("#create-listProvince-modal").modal("show");
}

//Ham xu ly su kien khi nut create New Pet duoc an
function onBtnCreateNewProvinceNowOnModalClick() {
    var vNewProvinceObject = {
        name: "",
        code: "",

    };
    //B1: Thu thap du lieu
    getCreateNewProvinceOnModal(vNewProvinceObject);
    // B2: Validate data
    var vIsValiableData = validateDataProvince(vNewProvinceObject);
    if (vIsValiableData) {
        $.ajax({
            url: gBASE_URL + "province/create",
            type: 'POST',
            contentType: gCONTENT_TYPE,
            dataType: 'JSON',
            data: JSON.stringify(vNewProvinceObject),
            success: postProvinceDataSuccess,
            error: postProvinceDataFailed,
        });
    }
}

function createNewDistrictByProvinceId(paramProvinceId) {
    var vNewDistrictObject = {
        name: "",
        prefix: "",
        province_id: paramProvinceId,
    };
    //B1: Thu thap du lieu
    getCreateNewDistrictOnModal(vNewDistrictObject);
    //B2: Validate 
    var vIsValidateData = validateDataDistrict(vNewDistrictObject);
    if (vIsValidateData) {
        $.ajax({
            url: gBASE_URL + "district/create/" + paramProvinceId,
            type: 'POST',
            contentType: gCONTENT_TYPE,
            dataType: 'JSON',
            data: JSON.stringify(vNewDistrictObject),
            success: postDistrictDataSuccess,
            error: postDistrictDataFailed,
        });
    }

}

function createNewWardByDistrictId(paramCreatedDistrictId) {
    var vNewWardObject = {
        name: "",
        prefix: "",
    };
    //B1: Thu thap du lieu
    getCreateNewWardOnModal(vNewWardObject);
    //B2: Validate 
    var vIsValidateData = validateWardData(vNewWardObject);
    if (vIsValidateData) {
        $.ajax({
            url: gBASE_URL + "ward/create/" + paramCreatedDistrictId,
            type: 'POST',
            contentType: gCONTENT_TYPE,
            dataType: 'JSON',
            data: JSON.stringify(vNewWardObject),
            success: postWardDataSuccess,
            error: postWardDataFailed,
        });
    }
}


//Ham xu ly su kien khu an nut sua
function onBtnEditPetClick(paramBtnEdit) {
    gProvinceIdToDelete = getPetIdFromButton(paramBtnEdit);

    getPetById(gProvinceIdToDelete);
}


//Ham xu ly su kien khi nhan nut Update
function onBtnUpdatePetModalClick() {
    var vUpdatePetObject = {
        name: "",
        type: "",
        description: "",
        imageUrl: "",
        price: "",
        promotionPrice: "",
        discount: "",
    };
    //B1: Thu thap du lieu
    getUpdatePetModal(vUpdatePetObject);

    var vIsValiableData = validateDataProvince(vUpdatePetObject);
    if (vIsValiableData) {
        $.ajax({
            url: vBASE_URL_PETS + gProvinceIdToDelete,
            type: "PUT",
            contentType: gCONTENT_TYPE,
            dataType: "JSON",
            data: JSON.stringify(vUpdatePetObject),
            success: function (paramResponse) {
                handleUpdatePetSuccess();
            },
            error: function (paramErr) {
                console.log(paramErr.status);
            }
        })
    }
}

//Ham xu ly su kien khi nhan nut xoa
function onBtnDeleteProvineClick(paramBtnDelete) {
    gProvinceIdToDelete = getProvinceIdFromButton(paramBtnDelete);

    $("#delete-confirm-modal").modal("show");
}


//Ham xu ly su kien khi nhan nut Xoa tren modal
function onBtnConfirmDeleteModal() {
    $.ajax({
        url: gBASE_URL + "province/delete/" + gProvinceIdToDelete,
        type: "DELETE",
        success: function (paramRes) {
            handleDeleteProvinceSuccess();
        },
        error: function (paramErr) {
            console.log(paramErr.status);
        }
    })
}


function postProvinceDataSuccess(paramCreateProvinceRes) {
    vCreatedProvinceId = paramCreateProvinceRes.id;
    handleAddNewProvinceSuccess(paramCreateProvinceRes.id);
}
function postProvinceDataFailed(paramError) {
    console.log(paramError.Status);
}

function postDistrictDataSuccess(paramCreateDistrictRes) {
    console.log(paramCreateDistrictRes)
    vCreatedDistrictId = paramCreateDistrictRes.id;
    handleAddNewDistrictSuccess(paramCreateDistrictRes.id);
}

function postDistrictDataFailed(paramError) {
    console.log(paramError.Status);
}

function postWardDataSuccess() {
    handleAddNewWardSuccess();
}

function postWardDataFailed(paramError) {
    confirm.log(paramError.Status);
}


/**REGION 4 */

//Ham get All pet

function getAllProvince() {
    $.ajax({
        type: 'get',
        url: vBASE_URL_PROVINCE,
        dataType: 'json',
        success: getAllProvinceSuccess,
        error: getAllProvinceFailed,
    });
}
//Ham getAllProvinceSuccess
function getAllProvinceSuccess(paramProvinceRes) {
    console.log(`Get all pet success
--------------------------------------
    ${paramProvinceRes}
`);
    var vPerRows = paramProvinceRes;
    console.log(vPerRows);
    loadAllProvinceDataToTable(vPerRows);
}
//Ham getAllPetsFailes
function getAllProvinceFailed(paramError) {
    console.log(paramError.Status);
}


//Ham loadAllProvinceDataToTable
function loadAllProvinceDataToTable(paramProvince) {
    vListProvinceTable.clear();
    vListProvinceTable.rows.add(paramProvince);
    vListProvinceTable.draw();
}

function getProvinceById(paramVoucherId) {
    $.ajax({
        url: "http://localhost:8088/api/province/detail/" + paramVoucherId,
        type: "GET",
        dataType: "json",
        success: function (paramRes) {
            console.log(paramRes);
            loadProvinceToForm(paramRes);
            getDistrictByProvinceId(paramRes.id);
        },
        error: function (err) {
            console.log(err.response);
        }
    })
}

function loadProvinceToForm(paramProvince) {
    gProvinceIdId = paramProvince.id;
    $("#input-province-name").val(paramProvince.name);
    $("#input-province-code").val(paramProvince.code);

}





//find brandTypes array by brandId
function getDistrictByProvinceId(bProvinceId) {
    $.ajax({
        url: "http://localhost:8088/api/province/" + bProvinceId + "/districts",
        method: "GET",
        success: function (pObjRes) {
            console.log(bProvinceId);
            loadDataToDistrictSelect(pObjRes);
        },
        error: function (pXhrObj) {
            console.log(pXhrObj);
        }
    });
}

function loadDataToDistrictSelect(pDistrictList) {
    if (pDistrictList.length > 0) {
        gDistrictNameSelectElement.html("");
        gWardSelectElement.html("");
        gDistrictNameSelectElement.prop("disabled", false);
        console.log(pDistrictList.length);
        for (i = 0; i < pDistrictList.length; i++) {
            var bDistrictOption = $("<option/>");
            bDistrictOption.prop("value", pDistrictList[i].id);
            bDistrictOption.prop("text", pDistrictList[i].name);
            gDistrictNameSelectElement.append(bDistrictOption);
        };
    } else {
        gDistrictNameSelectElement.prop("disabled", "disabled");
    }
}





gDistrictNameSelectElement.on("change", function () {
    gWardSelectElement.html("");
    var bDistrictId = $(this).val();

    getWardByDistrictId(bDistrictId);
});

function getWardByDistrictId(bDistrictId) {
    $.ajax({
        url: "http://localhost:8088/api/district/" + bDistrictId + "/wards",
        method: "GET",
        success: function (pObjRes) {
            console.log("hello");
            console.log(bDistrictId);
            console.log(pObjRes);
            loadDataToWardNameSelect(pObjRes);
        },
        error: function (pXhrObj) {
            console.log(pXhrObj);
        }
    });
}

function loadDataToWardNameSelect(pWardList) {
    if (pWardList.length > 0) {
        gWardSelectElement.prop("disabled", false);

        for (i = 0; i < pWardList.length; i++) {
            var bWardOption = $("<option/>");
            bWardOption.prop("value", pWardList[i].id);
            bWardOption.prop("text", pWardList[i].name);
            gWardSelectElement.append(bWardOption);
        };
    } else {
        gWardSelectElement.prop("disabled", "disabled");
    }
}

























































































//Ham thu thap du lieu de tao pet moi 
function getCreateNewProvinceOnModal(paramProvinceObject) {
    paramProvinceObject.name = $("#input-create-province-name").val().trim();
    paramProvinceObject.code = $("#input-create-province-code").val().trim();

}

function getCreateNewDistrictOnModal(paramDistrictObject) {
    paramDistrictObject.name = $("#input-create-district-name").val().trim();
    paramDistrictObject.prefix = $("#input-create-district-prefix").val().trim();
}

function getCreateNewWardOnModal(paramWardObject) {
    paramWardObject.name = $("#input-create-ward-name").val().trim();
    paramWardObject.prefix = $("#input-create-ward-prefix").val().trim();
}

//Ham thu thap du lieu de sua pet
function getUpdatePetModal(paramPetUpdateObj) {
    paramPetUpdateObj.name = $("#input-update-name").val().trim();
    paramPetUpdateObj.description = $("#input-update-description").val().trim();
    paramPetUpdateObj.imageUrl = $("#input-update-imageUrl").val().trim();
    paramPetUpdateObj.price = $("#input-update-price").val().trim();
    paramPetUpdateObj.promotionPrice = $("#input-update-promotionPrice").val().trim();
    paramPetUpdateObj.discount = $("#input-update-discount").val().trim();
    paramPetUpdateObj.type = $("#select-update-type").val().trim();
}

//Ham validate du lieu tai pet
function validateDataProvince(paramProvinceObject) {
    if (paramProvinceObject.name === "") {
        alert("Ten can nhap");
        return false;
    }
    if (paramProvinceObject.code === "") {
        alert("code can nhap");
        return false;
    }
    return true;
}

function validateDataDistrict(paramDistrictObject) {
    if (paramDistrictObject.name === "") {
        alert("Ten can nhap");
        return false;
    }
    if (paramDistrictObject.prefix === "") {
        alert("prefix can nhap");
        return false;
    }
    return true;
}

function validateWardData(paramWard) {
    if (paramWard.name === "") {
        alert("Ten can nhap");
        return false;
    }
    if (paramWard.prefix === "") {
        alert("prefix can nhap");
        return false;
    }
    return true;
}

//Ham xu ly sau khi post success
function handleAddNewProvinceSuccess(paramProvinceId) {
    console.log("Create new Province Successfully");
    $("#input-create-district-name").prop("disabled", false);
    // Kích hoạt ô input 2
    $("#input-create-district-prefix").prop("disabled", false);



}


function handleAddNewDistrictSuccess(paramDistrictId) {
    console.log("Create new District Successfully");

    $("#input-create-ward-name").prop("disabled", false);
    // Kích hoạt ô input 2
    $("#input-create-ward-prefix").prop("disabled", false);

}

function handleAddNewWardSuccess() {
    alert("Successfully");
    getAllProvince();
    // resertCreateProvinceForm();
    // $("#create-listProvince-modal").modal("hide");
}

//ham resertCreatePetForm
function resertCreateProvinceForm() {
    $("#input-create-province-name").val('');
    $("#input-create-province-code").val('');
    $("#input-create-district-name").val('');
    $("#input-create-district-prefix").val('');
    $("#input-create-ward-name").val('');
    $("#input-create-ward-prefix").val('');
    // $("#select-create-type").val('');
}

//Ham get ID by click
function getProvinceIdFromButton(paramBtn) {
    var vTableRow = $(paramBtn).parents("tr");
    var vProinceRowData = vListProvinceTable.row(vTableRow).data();
    console.log(vProinceRowData.id);
    return vProinceRowData.id;
}


function handleDeleteProvinceSuccess() {
    alert("Xoa thanh cong");
    getAllProvince();
    $("#delete-confirm-modal").modal("hide");
}

//Ham get Pet by ID
function getPetById(paramPetId) {
    $.ajax({
        url: vBASE_URL_PETS + paramPetId,
        type: "GET",
        success: function (paramResponse) {
            showPetDataToUpdateModal(paramResponse);
        },
        error: function (paramError) {
            console.log(paramError.status);
        }
    });
    $("#update-listPet-modal").modal("show");
}

function showPetDataToUpdateModal(paramPetId) {
    $("#input-update-name").val(paramPetId.name);
    $("#input-update-description").val(paramPetId.description);
    $("#input-update-imageUrl").val(paramPetId.imageUrl);
    $(".img-cover-old").html(`<img style="max-width: 108px;" src="${paramPetId.imageUrl}">`);
    $("#input-update-price").val(paramPetId.price);
    $("#input-update-promotionPrice").val(paramPetId.promotionPrice);
    $("#input-update-discount").val(paramPetId.discount);
    $("#select-update-type").val(paramPetId.type);
}


function handleUpdatePetSuccess() {
    alert("Update successfully");
    getAllPets();
    resertUpdateForm();
    $("#update-listPet-modal").modal("hide");
}

function resertUpdateForm() {
    $("#input-update-name").val('');
    $("#input-update-description").val('');
    $("#input-update-imageUrl").val('');
    $("#input-update-price").val('');
    $("#input-update-promotionPrice").val('');
    $("#input-update-discount").val('');
}



//PHAN FILTER


$("#btn-filter").on("click", function () {
    onBtnFilterClick(this)
});




$(document).on('click', ".btn-back-back-back-back-back", function () {
    onBtnBackBackBackBackClick(this);
    console.log("Ban vua nhan nut back")
})

function onBtnBackBackBackBackClick() {
    console.log("ban vua nhan nut back");
    location.reload();
}


