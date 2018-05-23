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
        <title>Welcome page</title>
    </head>
    <body>

        <div class="jumbotron" id="jens">
            <div class="row">
                <div class="col-sm-6" id="venstre"><div class="text-center" style="padding:200px 0">
                        <div class="logo">login</div>
                        <!-- Main Form -->
                        <div class="login-form-1">
                            <form class="text-left" name="login" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="login">
                                <div class="login-form-main-message"></div>
                                <div class="main-login-form">
                                    <div class="login-group">
                                        <div class="form-group">
                                            <label for="lg_username" class="sr-only">Username</label>
                                            <input type="text" class="form-control" id="lg_username" name="email" placeholder="username">
                                        </div>
                                        <div class="form-group">
                                            <label for="lg_password" class="sr-only">Password</label>
                                            <input type="password" class="form-control" id="lg_password" name="password" placeholder="password">
                                        </div>
                                        <div class="form-group login-group-checkbox">
                                            <input type="checkbox" id="lg_remember" name="lg_remember">
                                            <label for="lg_remember">remember</label>
                                        </div>
                                    </div>
                                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                                </div>
                            </form>
                        </div>
                        <!-- end:Main Form -->
                    </div></div>
                <div class="col-sm-6" id="hojre"><!-- Where all the magic happens -->
                    <!-- LOGIN FORM -->


                    <!-- REGISTRATION FORM -->
                    <div class="text-center" style="padding:200px 0">
                        <div class="logo">register</div>
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
                                            <label for="reg_password" class="sr-only">Password</label>
                                            <input type="password" class="form-control" id="reg_password" name="password1" placeholder="password">
                                        </div>
                                        <div class="form-group">
                                            <label for="reg_password_confirm" class="sr-only">Password Confirm</label>
                                            <input type="password" class="form-control" id="reg_password_confirm" name="password2" placeholder="confirm password">
                                        </div>
                                    </div>
                                    <button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
                                </div>
                            </form>
                        </div>
                        <!-- end:Main Form -->
                    </div></div>
            </div>


            <% String error = (String) request.getAttribute("error");
                if (error != null) {%>
            <H2>Error!!</h2>
            <p><%= error%>
                <% }
                %>
                </body>
                </html>
