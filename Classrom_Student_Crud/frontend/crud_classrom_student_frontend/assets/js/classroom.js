const gREQUEST_STATUS_OK = 200;
const gREQUEST_CREATE_OK = 201; // status 201 là tạo mới thành công
const gREQUEST_READY_STATUS_FINISH_AND_OK = 4;
const gCONTENT_TYPE = "application/json;charset=UTF-8";

const gBASE_URL = "http://localhost:8088/api/classroom/";
const gBASE_URL_STUDENT = "http://localhost:8088/api/student/";
var vNumberical = 1;
var gClassroomId = 0;
var vLIST_CLASSROOM_COL = ["id", "classroomCode", "classroomName", "teacherName",
    "phoneOfTeacher", "action"];

var classroomIdByClickAtRow = 0;

const gLIST_NUMBERIAL_COL = 0;
const gLIST_CLASSROOM_CODE_COL = 1;
const gLIST_CLASSROOM_NAME_COL = 2;
const gLIST_TEACHER_NAME_COL = 3;
const gLIST_PHONE_OF_TEACHER_COL = 4;
const gLIST_ACTION_COL = 5;

var vListClassroomTable = $("#classrooms-table").DataTable({
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
        { data: vLIST_CLASSROOM_COL[gLIST_NUMBERIAL_COL] },
        { data: vLIST_CLASSROOM_COL[gLIST_CLASSROOM_CODE_COL] },
        { data: vLIST_CLASSROOM_COL[gLIST_CLASSROOM_NAME_COL] },
        { data: vLIST_CLASSROOM_COL[gLIST_TEACHER_NAME_COL] },
        { data: vLIST_CLASSROOM_COL[gLIST_PHONE_OF_TEACHER_COL] },
        { data: vLIST_CLASSROOM_COL[gLIST_ACTION_COL] },
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

//gan su kien create 1 classroom 
$("#btn-create-classroom").on("click", function () {
    onBtnCreateNewClassroomClick(this);
    console.log("Nut them classroom")
});

//gan su kien create classroom tren modal
$("#btn-create-newClassroom").on('click', function () {
    console.log("Create classroom Now")
    onBtnCreateClassroomOnModalClick();
});

//Gan su kien Update classroom
$("#classrooms-table").on("click", ".btn-edit", function () {
    onBtnEditClick(this);
});

//Gan su kien Update classroom MODAL
$("#btn-update-classroom").on("click", function () {
    onBtnUpdateClassroomModalClick();
});

//Gan su kien Delete classrom
$("#classrooms-table").on("click", ".btn-delete", function () {
    onBtnDeleteClick(this);
});
//gan su kien confirm delete
$("#btn-confirm-delete-classroom").on("click", function () {
    onBtnConfirmDeleteModal();
})


$("#classrooms-table").on("click", "tr", function () {
    classroomIdByClickAtRow = vListClassroomTable.row(this).data().id;
    getClassroomByIdForForm(classroomIdByClickAtRow)
});

// Lấy nút "New Student"
var newStudentButton = document.getElementById('btn-create-student-by-classroomId');

// Thêm sự kiện click vào nút
newStudentButton.addEventListener('click', function (event) {
    // Ngăn chặn hành vi mặc định submit của form
    event.preventDefault();

    // Thực hiện các xử lý khác tại đây
    // Ví dụ: hiển thị một modal để người dùng nhập thông tin học sinh mới
});

$("#btn-create-student-by-classroomId").on("click", function () {
    onBtnCreateNewStudentClick(this);
});

//gan su kien create classroom tren modal
$("#btn-create-newStudent").on('click', function () {
    console.log(classroomIdByClickAtRow);
    onBtnCreateStudentOnModalClick();
});

/**REGION 3 */

function onPageLoading() {
    getAllClassroom();
}

//Ham xu ly su kien khi nhan nut create 1 classroom
function onBtnCreateNewClassroomClick() {
    $("#create-classroom-modal").modal("show");
}

function onBtnEditClick(paramBtnEdit) {
    gClassroomId = getClassroomIdByButton(paramBtnEdit);
    getClassroomById(gClassroomId);
}

function onBtnDeleteClick(paramBtnDel) {
    gClassroomId = getClassroomIdByButton(paramBtnDel);
    $("#delete-confirm-modal").modal("show");
}

function onBtnCreateNewStudentClick() {
    $("#create-student-modal").modal("show");
}

/**REGION 4 */


//GET ALL CLASSROOM
function getAllClassroom() {
    $.ajax({
        type: 'GET',
        url: gBASE_URL + "all",
        dataType: 'json',
        success: getAllClassroomsSuccess,
        error: getAllClassroomsFailed,
    });
}
//Ham getAllclassroomsSuccess
function getAllClassroomsSuccess(paramClassroomRes) {
    console.log(`Get all classrooms success
--------------------------------------
            ${paramClassroomRes}`);
    var vPerRows = paramClassroomRes
    console.log(vPerRows);
    loadAllClassroomDataToTable(vPerRows);
}
//Ham getAllPetsFailes
function getAllClassroomsFailed(paramError) {
    console.log(paramError.Status);
}
//Ham loadAllClassroomDataToTable
function loadAllClassroomDataToTable(paramRows) {
    vListClassroomTable.clear();
    vListClassroomTable.rows.add(paramRows);
    vListClassroomTable.draw();
}


//CREATE CLASSROOM
//Ham xu ly su kien khi nut create New Voucher duoc an
function onBtnCreateClassroomOnModalClick() {
    var vNewClassroomObj = {
        id: "",
        classroomCode: "",
        classroomName: "",
        teacherName: "",
        phoneOfTeacher: "",
    };
    //B1: Thu thap du lieu
    getCreateNewClassroomOnModal(vNewClassroomObj);
    // B2: Validate data
    var vIsValidableData = validateDataClassroom(vNewClassroomObj);
    if (vIsValidableData) {
        callApiCreateClassroom(vNewClassroomObj);

    }
}
function postVoucherDataSuccess(paramCreateRes) {
    handleAddVoucherSuccess();
}
function postVoucherDataFailed(paramError) {
    console.log(paramError.Status);
}
function getCreateNewClassroomOnModal(paramRes) {
    paramRes.classroomCode = $("#input-create-classroomCode").val().trim();
    paramRes.classroomName = $("#input-create-classroomName").val().trim();
    paramRes.teacherName = $("#input-create-teacherName").val().trim();
    paramRes.phoneOfTeacher = $("#input-create-teacherPhone").val().trim();
}
//Ham validate du lieu tai pet
function validateDataClassroom(paramObject) {
    if (!paramObject.classroomCode) {
        showToast(3, "classroomCode can nhap");
        return false;
    }
    if (!paramObject.classroomName) {
        showToast(3, "classroomName can nhap");
        return false;
    }
    if (!paramObject.teacherName) {
        showToast(3, "teacherName can nhap");
        return false;
    }
    if (!paramObject.phoneOfTeacher) {
        showToast(3, "phoneOfTeacher can nhap");
        return false;
    }
    if (isClassroomCodeUniqueable(paramObject.classroomCode)) {
        showToast(3, "classroomCode da ton tai");
        return false;
    }
    return true;
}


function isClassroomCodeUniqueable(paramClassroomCode) {
    var vClassroomId = $("#input-create-classroomId").val();
    if (!vClassroomId) {
        vClassroomId = 0;
    }

    const vAPI_URL_CHECK_CLASSROOM = gBASE_URL + "check/" + vClassroomId + "?classroomCode=" + paramClassroomCode;
    let result;
    $.ajax({
        url: vAPI_URL_CHECK_CLASSROOM,
        type: "GET",
        success: function (paramRes) {
            result = paramRes;
        },
        error: function (parramErr) {
            console.log(parramErr.Status);
        },
        async: false,
    });
    return result;
}

function callApiCreateClassroom(paramNewClassroom) {
    const vAPI_URL = gBASE_URL + "create";
    $.ajax({
        url: vAPI_URL,
        type: "POST",
        contentType: gCONTENT_TYPE,
        data: JSON.stringify(paramNewClassroom),
        success: postClassroomDataSuccess,
        error: postClassroomDataFailed,
    })
}
function postClassroomDataSuccess(paramCreateRes) {
    handleCreateClassroomSuccess();
}
function postClassroomDataFailed(paramError) {
    console.log(paramError.Status);
}

//Ham xu ly sau khi post success
function handleCreateClassroomSuccess() {
    showToast(1, "Create New Classroom Successfully");
    getAllClassroom();
    resertCreatedClassroomForm();
    $("#create-classroom-modal").modal('hide');
}

//ham resertCreateVoucherForm
function resertCreatedClassroomForm() {
    $("#input-create-classroomCode").val('');
    $("#input-create-classroomName").val('');
    $("#input-create-teacherName").val('');
    $("#input-create-teacherPhone").val('');

}

//UPDATE CLASSROOM
function getClassroomById(paramClassroomId) {
    $.ajax({
        url: gBASE_URL + "detail/" + paramClassroomId,
        type: "GET",
        success: function (paramResponse) {
            showClassroomDataToUpdateModal(paramResponse);
            loadClassroomDataToForm(paramResponse);
        },
        error: function (paramError) {
            console.log(paramError.status);
        }
    });
    $("#update-classroom-modal").modal("show");
}

function showClassroomDataToUpdateModal(paramObj) {
    $("#input-update-classroomCode").val(paramObj.classroomCode);
    $("#input-update-classroomName").val(paramObj.classroomName);
    $("#input-update-teacherName").val(paramObj.teacherName);
    $("#input-update-teacherPhone").val(paramObj.phoneOfTeacher);
}

function onBtnUpdateClassroomModalClick() {
    var vUpdateClassroomOjb = {
        id: "",
        classroomCode: "",
        classroomName: "",
        teacherName: "",
        phoneOfTeacher: "",
    };
    //B1: Thu thap du lieu
    getUpdateClassroomOnModal(vUpdateClassroomOjb);
    // B2: Validate data
    var vIsValidableData = validateDataUpdateClassroom(vUpdateClassroomOjb);

    if (vIsValidableData) {

        callApiToUpdateClassroom(gClassroomId, vUpdateClassroomOjb)

    }
}

function getUpdateClassroomOnModal(paramRes) {
    paramRes.classroomCode = $("#input-update-classroomCode").val().trim();
    paramRes.classroomName = $("#input-update-classroomName").val().trim();
    paramRes.teacherName = $("#input-update-teacherName").val().trim();
    paramRes.phoneOfTeacher = $("#input-update-teacherPhone").val().trim();
}

function validateDataUpdateClassroom(paramObject) {
    if (!paramObject.classroomCode) {
        showToast(3, "classroomCode can nhap");
        return false;
    }
    if (!paramObject.classroomName) {
        showToast(3, "classroomName can nhap");
        return false;
    }
    if (!paramObject.teacherName) {
        showToast(3, "teacherName can nhap");
        return false;
    }
    if (!paramObject.phoneOfTeacher) {
        showToast(3, "phoneOfTeacher can nhap");
        return false;
    }
    // if (isClassroomCodeUniqueable(paramObject.classroomCode)) {
    //     showToast(3, "classroomCode da ton tai");
    //     return false;
    // }
    return true;
}

function callApiToUpdateClassroom(paramClassroomId, paramObj) {
    const vAPI_URL_UPDATE_VOUCHER = gBASE_URL + "update/" + paramClassroomId;
    $.ajax({
        url: vAPI_URL_UPDATE_VOUCHER,
        type: "PUT",
        contentType: gCONTENT_TYPE,
        dataType: "JSON",
        data: JSON.stringify(paramObj),
        success: function (paramResponse) {
            handleUpdateClassroomSuccess();
        },
        error: function (paramErr) {
            console.log(paramErr.status);
        }
    })
}

function handleUpdateClassroomSuccess() {
    showToast(1, "Update CLASSROOM Successfully");
    getAllClassroom();
    resertUpdatedClassroomForm();
}

function resertUpdatedClassroomForm() {
    $("#input-update-classroomCode").val('');
    $("#input-update-classroomName").val('');
    $("#input-update-teacherName").val('');
    $("#input-update-teacherPhone").val('');
    $("#update-classroom-modal").modal('hide');
}

//DELETE CLASSROOM

function onBtnConfirmDeleteModal() {
    $.ajax({
        url: gBASE_URL + "delete/" + gClassroomId,
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
    showToast(1, "Delete CLASSROOM Successfully");
    getAllClassroom();
    $("#delete-confirm-modal").modal("hide");
}



//----------------------------------------//
function getClassroomIdByButton(paramBtn) {
    var vTableRow = $(paramBtn).parents("tr");
    var vClassroomRowData = vListClassroomTable.row(vTableRow).data();
    console.log(vClassroomRowData);
    return vClassroomRowData.id;
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

function getClassroomByIdForForm(paramClassroomId) {
    $.ajax({
        url: gBASE_URL + "detail/" + paramClassroomId,
        type: "GET",
        success: function (paramResponse) {
            console.log(paramResponse)
            loadClassroomDataToForm(paramResponse);
        },
        error: function (paramError) {
            console.log(paramError.status);
        }
    });
};

function loadClassroomDataToForm(paramObj) {
    $("#input-form-classroomCode").val(paramObj.classroomCode).prop("disabled", true);
    $("#input-form-classroomName").val(paramObj.classroomName).prop("disabled", true);
    $("#input-form-teacherName").val(paramObj.teacherName).prop("disabled", true);
    $("#input-form-teacherPhone").val(paramObj.phoneOfTeacher).prop("disabled", true);
    $("#btn-create-student-by-classroomId").prop("disabled", false);
}


//CREATE STUDENT
//Ham xu ly su kien khi nut create New Voucher duoc an
function onBtnCreateStudentOnModalClick() {
    var vNewStudentObj = {
        studentCode: "",
        studentName: "",
        gender: "",
        dateOfBirth: "",
        address: "",
        studentPhone: "",
    };
    //B1: Thu thap du lieu
    getCreateNewStudentOnModal(vNewStudentObj);
    // B2: Validate data
    var vIsValidableData = validateDataStudent(vNewStudentObj);
    if (vIsValidableData) {
        callApiCreateStudent(vNewStudentObj);

    }
}

function getCreateNewStudentOnModal(paramRes) {
    paramRes.studentCode = $("#input-create-studentCode").val().trim();
    paramRes.studentName = $("#input-create-studentName").val().trim();
    paramRes.gender = $("#input-create-studentGender").val().trim();
    paramRes.dateOfBirth = $("#input-create-dateOfBirth").val().trim();
    paramRes.address = $("#input-create-address").val().trim();
    paramRes.studentPhone = $("#input-create-studentPhone").val().trim();
}
//Ham validate du lieu tai pet
function validateDataStudent(paramObject) {
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
    if (isStudentCodeUniqueable(paramObject.studentCode)) {
        showToast(3, "studentCode da ton tai");
        return false;
    }
    return true;
}


function isStudentCodeUniqueable(paramStudentCode) {
    var vStudentId = $("#input-create-studentId").val();
    if (!vStudentId) {
        vStudentId = 0;
    }

    const vAPI_URL_CHECK_STUDENT = gBASE_URL_STUDENT + "check/" + vStudentId + "?studentCode=" + paramStudentCode;
    let result;
    $.ajax({
        url: vAPI_URL_CHECK_STUDENT,
        type: "GET",
        success: function (paramRes) {
            result = paramRes;
        },
        error: function (parramErr) {
            console.log(parramErr.Status);
        },
        async: false,
    });
    return result;
}

function callApiCreateStudent(paramNewStudent) {
    const vAPI_URL = gBASE_URL_STUDENT + "create/" + classroomIdByClickAtRow;
    $.ajax({
        url: vAPI_URL,
        type: "POST",
        contentType: gCONTENT_TYPE,
        data: JSON.stringify(paramNewStudent),
        success: postStudentDataSuccess,
        error: postStudentDataFailed,
    })
}
function postStudentDataSuccess(paramCreateRes) {
    handleCreateStudentSuccess();
}
function postStudentDataFailed(paramError) {
    console.log(paramError.Status);
}

//Ham xu ly sau khi post success
function handleCreateStudentSuccess() {
    showToast(1, "Create New Classroom Successfully, change to STUDENT page to see your new student");
    getAllClassroom();
    resertCreatedStudentForm();
    resertInfoClassroomFormf();
    // $("#create-classroom-modal").modal('hide');
}

//ham resertCreateVoucherForm
function resertCreatedStudentForm() {
    $("#input-create-studentCode").val('');
    $("#input-create-studentName").val('');
    $("#input-create-studentGender").val('');
    $("#input-create-dateOfBirth").val('');
    $("#input-create-address").val('');
    $("#input-create-studentPhone").val('');
    $("#create-student-modal").modal('hide')

}

function resertInfoClassroomFormf() {
    $("#input-form-classroomCode").val('');
    $("#input-form-classroomName").val('');
    $("#input-form-teacherName").val('');
    $("#input-form-teacherPhone").val('');
}