const gREQUEST_STATUS_OK = 200;
const gREQUEST_CREATE_OK = 201; // status 201 là tạo mới thành công
const gREQUEST_READY_STATUS_FINISH_AND_OK = 4;
const gCONTENT_TYPE = "application/json;charset=UTF-8";

const gBASE_URL = "http://localhost:8088/api/student/";
var vNumberical = 1;
var gClassroomId = 0;
var gStudentId = 0;
var vLIST_STUDENT_COL = ["id", "studentCode", "studentName", "gender",
    "dateOfBirth", "address", "studentPhone", "action"];

const gLIST_NUMBERIAL_COL = 0;
const gLIST_STUDENT_CODE = 1;
const gLIST_STUDENT_NAME_NAME_COL = 2;
const gLIST_GENDER_COL = 3;
const gLIST_STUDENT_BIRTHDAY_COL = 4;
const gLIST_ADDRESS_COL = 5;
const gLIST_PHONE_NUMBER_COL = 6;
const gLIST_ACTION_COL = 7;

var vListStudentTable = $("#students-table").DataTable({
    responsive: true,
    pagingType: "full_numbers",
    oLanguage: {
        oPaginate: {
            sFirst: '<span class="pagination-default"><i class="fas fa-angle-double-left"></i></span>',
            sNext: '<span class="pagination-default"><i class="fas fa-angle-right"></i></span>',
            sPrevious: '<span class="pagination-default"><i class="fas fa-angle-left"></i></span>',
            sLast: '<span class="pagination-default"><i class="fas fa-angle-double-right"></i></span>',
        },
    },

    columns: [
        { data: vLIST_STUDENT_COL[gLIST_NUMBERIAL_COL] },
        { data: vLIST_STUDENT_COL[gLIST_STUDENT_CODE] },
        { data: vLIST_STUDENT_COL[gLIST_STUDENT_NAME_NAME_COL] },
        { data: vLIST_STUDENT_COL[gLIST_GENDER_COL] },
        { data: vLIST_STUDENT_COL[gLIST_STUDENT_BIRTHDAY_COL] },
        { data: vLIST_STUDENT_COL[gLIST_ADDRESS_COL] },
        { data: vLIST_STUDENT_COL[gLIST_PHONE_NUMBER_COL] },
        { data: vLIST_STUDENT_COL[gLIST_ACTION_COL] },
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
            <div class="text-nowrap">
              <i class="fas fa-edit text-success btn-edit mr-2" role="button" title="Sửa"></i>
              <i class="fas fa-trash text-danger btn-delete" role="button" title="Xóa"></i>
            </div>
                `,
            class: "text-center",
            orderable: false,

        },

    ],
});

/**REGION 2 */

$(document).ready(function () {
    onPageLoading();
});

//Gan su kien Update student
$("#students-table").on("click", ".btn-edit", function () {
    onBtnEditClick(this);
});

//Gan su kien Update student MODAL
$("#btn-update-student").on("click", function () {
    onBtnUpdateStudentModalClick();
});

//Gan su kien Delete student
$("#students-table").on("click", ".btn-delete", function () {
    onBtnDeleteClick(this);
});
//gan su kien confirm delete
$("#btn-confirm-delete-student").on("click", function () {
    onBtnConfirmDeleteModal();
})

/**REGION 3 */

function onPageLoading() {
    getAllStudent();
}


function onBtnEditClick(paramBtn) {
    gStudentId = getStudentIdByButton(paramBtn);
    getStudentById(gStudentId);
}

function onBtnDeleteClick(paramBtnDel) {
    gStudentId = getStudentIdByButton(paramBtnDel);
    $("#delete-confirm-modal").modal("show");
}


/**REGION 4 */
//GET ALL CLASSROOM
function getAllStudent() {
    $.ajax({
        type: 'GET',
        url: gBASE_URL + "all",
        dataType: 'json',
        success: getAllStudentsSuccess,
        error: getAllStudentsFailed,
    });
}

//Ham getAllStudentsSuccess
function getAllStudentsSuccess(paramStudentRes) {
    console.log(`Get all Student success
--------------------------------------
            ${paramStudentRes}`);
    var vPerRows = paramStudentRes
    console.log(vPerRows);
    loadAllStudentDataToTable(vPerRows);
}
//Ham getAllPetsFailes
function getAllStudentsFailed(paramError) {
    console.log(paramError.Status);
}
//Ham loadAllStudentDataToTable
function loadAllStudentDataToTable(paramRows) {
    vListStudentTable.clear();
    vListStudentTable.rows.add(paramRows);
    vListStudentTable.draw();
}

//UPDATE CLASSROOM
function getStudentById(paramStudentId) {
    $.ajax({
        url: gBASE_URL + "detail/" + paramStudentId,
        type: "GET",
        success: function (paramResponse) {
            showStudentDataToUpdateModal(paramResponse);
        },
        error: function (paramError) {
            console.log(paramError.status);
        }
    });
    $("#update-student-modal").modal("show");
}

function showStudentDataToUpdateModal(paramObj) {
    $("#input-update-studentCode").val(paramObj.studentCode);
    $("#input-update-studentName").val(paramObj.studentName);
    $("#input-update-studentGender").val(paramObj.gender);
    $("#input-update-dateOfBirth").val(paramObj.dateOfBirth);
    $("#input-update-address").val(paramObj.address);
    $("#input-update-studentPhone").val(paramObj.studentPhone);
}

function onBtnUpdateStudentModalClick() {
    var vUpdateStudentobj = {
        id: "",
        studentCode: "",
        studentName: "",
        gender: "",
        dateOfBirth: "",
        address: "",
        studentPhone: "",
    };
    //B1: Thu thap du lieu
    getUpdateStudentOnModal(vUpdateStudentobj);
    // B2: Validate data
    var vIsValidableData = validateDataUpdateStudent(vUpdateStudentobj);

    if (vIsValidableData) {

        callApiToUpdateStudent(gStudentId, vUpdateStudentobj)

    }
}

function getUpdateStudentOnModal(paramRes) {
    paramRes.studentCode = $("#input-update-studentCode").val().trim();
    paramRes.studentName = $("#input-update-studentName").val().trim();
    paramRes.gender = $("#input-update-studentGender").val().trim();
    paramRes.dateOfBirth = $("#input-update-dateOfBirth").val().trim();
    paramRes.address = $("#input-update-address").val().trim();
    paramRes.studentPhone = $("#input-update-studentPhone").val().trim();
}

function validateDataUpdateStudent(paramObject) {
    if (!paramObject.studentCode) {
        showToast(3, "studentCode can nhap");
        return false;
    }
    if (!paramObject.studentName) {
        showToast(3, "studentName can nhap");
        return false;
    }
    if (!paramObject.gender) {
        showToast(3, "gender can nhap");
        return false;
    }
    if (!paramObject.dateOfBirth) {
        showToast(3, "dateOfBirth can nhap");
        return false;
    }
    if (!paramObject.address) {
        showToast(3, "address can nhap");
        return false;
    }
    if (!paramObject.studentPhone) {
        showToast(3, "studentPhone can nhap");
        return false;
    }
    // if (isClassroomCodeUniqueable(paramObject.classroomCode)) {
    //     showToast(3, "classroomCode da ton tai");
    //     return false;
    // }
    return true;
}

function callApiToUpdateStudent(paramStudentId, paramObj) {
    const vAPI_URL_UPDATE_VOUCHER = gBASE_URL + "update/" + paramStudentId;
    $.ajax({
        url: vAPI_URL_UPDATE_VOUCHER,
        type: "PUT",
        contentType: gCONTENT_TYPE,
        dataType: "JSON",
        data: JSON.stringify(paramObj),
        success: function (paramResponse) {
            handleUpdateStudentSuccess();
        },
        error: function (paramErr) {
            console.log(paramErr.status);
        }
    })
}

function handleUpdateStudentSuccess() {
    showToast(1, "Update STUDENT Successfully");
    getAllStudent();
    resertUpdatedStudentForm();
}

function resertUpdatedStudentForm() {
    $("#input-update-studentCode").val('');
    $("#input-update-studentName").val('');
    $("#input-update-studentGender").val('');
    $("#input-update-dateOfBirth").val('');
    $("#input-update-address").val('');
    $("#input-update-studentPhone").val('');
    $("#update-student-modal").modal('hide')
}


//DELETE
function onBtnConfirmDeleteModal() {
    $.ajax({
        url: gBASE_URL + "delete/" + gStudentId,
        type: "DELETE",
        success: function (paramRes) {
            handleDeleteSuccess();
        },
        error: function (paramErr) {
            console.log(paramErr.status);
        }
    })
}

function handleDeleteSuccess() {
    showToast(1, "Delete STUDENT Successfully");
    getAllStudent();
    $("#delete-confirm-modal").modal("hide");
}

//------------------------------------------------------//
function getStudentIdByButton(paramBtn) {
    var vTableRow = $(paramBtn).parents("tr");
    var vStudentRowData = vListStudentTable.row(vTableRow).data();
    console.log(vStudentRowData);
    return vStudentRowData.id;
}


function showToast(paramType, paramMessage) {
    switch (paramType) {
        case 1:
            toastr.success(paramMessage);
            break;
        case 2:
            toastr.info(paramMessage);
            break;
        case 3:
            toastr.error(paramMessage);
            break;
        case 4:
            toastr.warning(paramMessage);
            break;
    }
}