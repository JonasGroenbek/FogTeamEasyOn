<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <head>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link rel="icon" href="assets/images/fog.jpg">
        <title>FOG Carport</title>
    </head>
    <body>
        
        <div class="jumbotron" id="jens">
        </div>

        <div class="row">
            <div class="col-sm-6" id="venstre"><div class="text-center" style="padding:20px 0">
                    <div class="logo">Login</div>
                    <!-- Main Form -->
                    <div class="login-form-1">
                        <form class="text-left" name="login" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="login">
                            <div class="login-form-main-message"></div>
                            <div class="main-login-form">
                                <div class="login-group">
                                    <div class="form-group">
                                        <label for="lg_username" class="sr-only">Email</label>
                                        <input type="text" class="form-control" id="lg_username" name="email" placeholder="Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="lg_password" class="sr-only">Kode</label>
                                        <input type="password" class="form-control" id="lg_password" name="password" placeholder="kode">
                                    </div>
                                </div>
                                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                            </div>
                        </form>
                    </div>
                    <!-- end:Main Form -->
                </div></div>
            <div class="col-sm-6" id="hojre">


                <!-- REGISTRATION FORM -->
                <div class="text-center" style="padding:20px 0">
                    <div class="logo">Registrer</div>
                    <!-- Main Form -->
                    <div class="login-form-1">
                        <form class="text-left" name="register" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="register">
                            <div class="login-form-main-message"></div>
                            <div class="main-login-form">
                                <div class="login-group">
                                    <div class="form-group">
                                        <label for="reg_username" class="sr-only">Email address</label>
                                        <input type="text" class="form-control" id="reg_username" name="email" placeholder="email">
                                    </div>
                                    <div class="form-group">
                                        <label for="reg_password" class="sr-only">Kode</label>
                                        <input type="password" class="form-control" id="reg_password" name="password1" placeholder="kode">
                                    </div>
                                    <div class="form-group">
                                        <label for="reg_password_confirm" class="sr-only">Bekræft kode</label>
                                        <input type="password" class="form-control" id="reg_password_confirm" name="password2" placeholder="bekræft kode">
                                    </div>
                                </div>
                                <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                            </div>
                        </form>
                    </div>
                    <!-- end:Main Form -->
                </div></div>
        </div>


        <jsp:include page="includes/footer.jsp"/>

        <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
        <H2>Error!!</h2>
        <p><%= error%>
            <% }
            %>
    </body>
</html>
