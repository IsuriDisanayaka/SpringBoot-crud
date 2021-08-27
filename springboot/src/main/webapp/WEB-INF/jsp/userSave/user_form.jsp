
<%--
  Created by IntelliJ IDEA.
  User: Ishu
  Date: 26/08/2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title> User Form</title>
</head>

<body>

<main style="background:  #e8dbea; " id="customerSave">




    <!--            title-->
    <h1 class="text-center modal-title  " style="color: #040b3b;position: absolute;
right: 157px;  font-size: 65px">USER</h1>


    <!--      save grid-->
    <div class="d-block" style="max-width: 700px; height:521px;
position: absolute;top:100px; left:41px; width: 586px;background-color: rgba(216, 200, 200, 0.51);">
        <form id="form" method="post">


            <div class="form-group w-50 " style="padding-left:40px;
            color: #100f0f;font-weight:bold;padding-top: 90px; " >
                <label>User ID</label>
                <input type class="form-control" id="id" required type="text">

            </div>

            <div class="form-group w-50 " style="padding-left: 40px;
             color: #151414; font-weight: bold; padding-top: 15px;">
                <label >User Name</label>
                <input class="form-control" id="name" type="text">

            </div>
            <div class="form-group w-50 " style="padding-left: 40px;
             color:#111111;font-weight:bold;padding-top: 15px;">
                <label>User Address</label>
                <input class="form-control" id="address" type="text">

            </div>
            <div class="form-group w-50 " style="padding-left: 40px;
             color:#111111;font-weight:bold;padding-top: 15px;">
                <label>User Password</label>
                <input class="form-control" id="password" type="text">

            </div>


            <!--search-->
            <div class="form-group  " style="left: 250px;position: absolute;
            color:#dccece;font-weight:bold;top:40px;width: 200px;" >
                <input type="text" class="form-control" id="InputSCID">
                <button class="btn " type="button" style="width: 166px;
            position: absolute; width: 100px;background: #154040; position: absolute; left:215px;color: white;
             top:0px;" id="btnSerachCust">Search</button>

            </div>



            <!--save.dalete/update-->


            <button class="btn btn-success" type="button" style="width: 100px;
            position: absolute; width: 140px; position: absolute; left: 30px; top:453px;" id="btnSaveCust">Save</button>
            <button class="btn btn-danger" type="button" style="width: 100px;
            position: absolute; width: 100px; position: absolute; left: 204px; top:453px;" id="btnDeleteCust">Delete</button>


            <button class="btn " type="button" style="width: 100px;
            position: absolute; width: 100px;background: orange; position: absolute; left:344px; top:453px;" id="btnUpdate">Update</button>



            <button class="btn " type="button" style="width: 100px;
            position: absolute; width: 100px; position: absolute;
            background: #44ff00; color: #1c0e0e; left: 465px;top:453px;" id="btnclearCust">Clear</button>

        </form>
    </div>


    <table class="table table-bordered table-hover w-60 "  style="position: absolute;
    color: #0a0a0a;  left: 875px; top: 150px;
background: #a05353; ">

        <thead style="background:#929abf63 ">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Contact</th>

        </tr>
        </thead>
        <tbody id="tblCustomer">

        </tbody>
    </table>

</main>

<script src="/resources/jquery/jquery.min.js"></script>
<script>
    $("#btnSaveCust").click(function () {

        let Id = $("#id").val();
        let Name = $("#name").val();
        let Address = $("#address").val();
        let Password = $("#password").val();

        var form = $('form').get(0);

        var data = new FormData(form);

        data.append("id",Id);
        data.append("name",Name);
        data.append("address",Address);
        data.append("password",Password);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/api/userSave",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log("SUCCESS : ", data);
                alert("Save User")
            },
            error: function (e) {
                console.log("ERROR : ", e);
                alert("Failed Save User")
            }
        });

    });
    $("#btnSerachCust").click(function () {
        loadSearchUser()
    });
    $("#btnUpdate").click(function (event) {
        let id = $("#id").val();
        let name = $("#name").val();
        let address = $("#address").val();
        let password= $("#password").val();

        event.preventDefault();

        var form = $('form').get(0);


        var data = new FormData(form);

        data.append("id",id);
        data.append("name",name);
        data.append("address",address);
        data.append("password",password);


        $.ajax({
            type: "PUT",
            enctype: 'multipart/form-data',
            url: "/api/userUpdate",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                console.log("SUCCESS : ", data);
                alert("Do you want Edit User?")

            },
            error: function (e) {
                console.log("ERROR : ", e);
                alert("Upadate Failed")


            }
        });

    });

    $("#btnDeleteCust").click(function (event) {
        let id = $("#id").val();
        let name = $("#name").val();
        let address = $("#address").val();
        let password= $("#password").val();

        event.preventDefault();
        alert("Do you want delete User?")

        var form = $('form').get(0);


        var data = new FormData(form);

        data.append("id",id);
        data.append("name",name);
        data.append("address",address);
        data.append("password",password);


        $.ajax({
            type: "DELETE",
            enctype: 'multipart/form-data',
            url: "/api/userDelete",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                console.log("SUCCESS : ", data);

            },
            error: function (e) {
                console.log("ERROR : ", e);


            }
        });

    });





    // search
    function loadSearchUser() {
        let tp = $('#InputSCID').val();
        $.ajax({
            url: "/api/user/" + tp,
            method: 'GET',
            success: function (data) {
                console.log(data);
                $("#id").val(data.id);
                $("#name").val(data.name);
                $("#address").val(data.address);
                $("#password").val(data.password);
                alert("User Found")
            }

        })}






</script>
</body>
</html>