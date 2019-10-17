
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "assets/img/backgrounds/1.jpg"
    , "assets/img/backgrounds/2.jpg"
    , "assets/img/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='nickname']").html('nickname');
        $(this).find("label[for='username']").html('Username');
        $(this).find("label[for='telephone']").html('Email');
        $(this).find("label[for='password']").html('Password');
        ////
        var nickname = $(this).find('input#nickname').val();
        var username = $(this).find('input#username').val();
        var telephone = $(this).find('input#telephone').val();
        var password = $(this).find('input#password').val();
        if(username == '') {
            $(this).find("label[for='username']").append("<span style='display:none' class='red'> - Please enter a valid username.</span>");
            $(this).find("label[for='username'] span").fadeIn('medium');
            return false;
        }
        if(nickname == '') {
            $(this).find("label[for='nickname']").append("<span style='display:none' class='red'> - Please enter your nickname.</span>");
            $(this).find("label[for='nickname'] span").fadeIn('medium');
            return false;
        }
        if(telephone == '') {
            $(this).find("label[for='telephone']").append("<span style='display:none' class='red'> - Please enter a valid telephone.</span>");
            $(this).find("label[for='telephone'] span").fadeIn('medium');
            return false;
        }
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - Please enter a valid password.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
    });


});


