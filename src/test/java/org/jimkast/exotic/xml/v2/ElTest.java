package org.jimkast.exotic.xml.v2;

import java.io.IOException;
import org.jimkast.exotic.xml.Attr;
import org.jimkast.exotic.xml.Attrs;
import org.jimkast.exotic.xml.Comment;
import org.jimkast.exotic.xml.El;
import org.jimkast.exotic.xml.FluentXml;
import org.jimkast.exotic.xml.OutIndent;
import org.jimkast.exotic.xml.Text;
import org.junit.Test;

public class ElTest {

    @Test
    public void name() throws IOException {
        new El("root",
            new Attrs(
                new Attr("id", "sgdfg"),
                new Attr("sdfg", "szf34t")
            ),
            new Text("roooot 345  t ws45yt we6y e567yu e5 u8r6i r6i r     "),
            new El("li",
                new Attrs(
                    new Attr("id", "sgdfg"),
                    new Attr("sdfg", "szf34t")
                ),
                new El("root",
                    new Attrs(
                        new Attr("id", "sgdfg"),
                        new Attr("sdfg", "szf34t")
                    ),
                    new El("li",
                        new Attrs(
                            new Attr("id", "sgdfg"),
                            new Attr("sdfg", "szf34t")
                        )
                    ),
                    new Comment("dgfrsw45ty d4y d56hyxfth fgh h f erg trtrg"),
                    new Text("  t ws45yt we6y e567yu e5 u8r6i r6i r     "),
                    new El("li",
                        new Attrs(
                            new Attr("id", "sgdfg"),
                            new Attr("sdfg", "szf34t")
                        ),
                        new Text("ar sw45t w45ty 54t 45 ty")
                    )
                )
            ),
            new Comment("dgfrsw45ty d4y d56hyxfth fgh h f erg trtrg"),
            new El("li",
                new Attrs(
                    new Attr("id", "sgdfg"),
                    new Attr("sdfg", "szf34t")
                )
            )
        ).serialize(new OutIndent(System.out));
    }


    @Test
    public void fluent() throws IOException {
        new FluentXml("root")
            .attr("id", "sdfg34r")
            .attr("type", "texttt")
            .append(
                new FluentXml("child1")
                    .attr("id", "rgf24523")

            )
            .serialize(System.out);
    }

    @Test
    public void indent() throws Exception {
        String xml = "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><title>Youtravel.com | Find great prices on amazing properties around the world.</title><meta name=\"description\" content=\"Leading accommodation provider to the trade offering travel agents and tour operators exclusive access to quality hotels and resorts around the world.\"><meta name=\"keywords\" content=\"Youtravel.com, you travel, accommodation provider, holidays, bed banks, hotels, all inclusive holiday, cheap hotels\"><meta name=\"theme-color\" content=\"#B4CC43\"><link rel=\"shortcut icon\" href=\"/assets/img/favicon-new.ico\" type=\"image/x-icon\"><meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link href=\"https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext\" rel=\"stylesheet\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-date-range-picker/0.16.4/daterangepicker.min.css\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.min.css\"><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.2.6/css/swiper.min.css\"><link rel=\"stylesheet\" href=\"/assets/css/styles.css?v=5c581f145c7baa7f7d5bd677543bac90daed588b\"></head><body><div class=\"login-page-wrap\"><div class=\"fullscreen-bg\" style=\"background-image: url('/assets/img/login-bg.jpg')\"></div><div class=\"login-page\"><div class=\"wrapper\" id=\"container\"><header class=\"login-header clearfix\"><nav class=\"left login-nav\"><ul><li><a href=\"/about\">ABOUT US</a></li><li><a href=\"/faq\">FAQ</a></li><li><a href=\"/contact\">CONTACT</a></li><li><a href=\"/news\">NEWS</a></li><li><a href=\"/careers\">CAREERS</a></li></ul></nav><div class=\"right login-header-links\"><a class=\"header-link\" href=\"tel:%2B44%20%280%29%20208%20588%209939\"><span class=\"ico phone-ico\"></span>+44 (0) 208 588 9939</a><a class=\"header-link\" href=\"mailto:info@youtravel.com\"><span class=\"ico folder-ico\"></span>info@youtravel.com</a><span class=\"header-link\"><a href=\"/register\" class=\"btn btn-bordered btn-white register-button\" data-modal-link=\"\" data-modal-preserve=\"\">Join us</a></span></div></header><section class=\"login-main-sec\"><div class=\"row \"><div class=\"col col2\"><div class=\"bnr\"><a class=\"bnr-lnk\" data-value=\"HOTEL:16433\" href=\"/hoteldetailsr.asp?hid=16433\" target=\"_blank\" data-search-hid=\"16433\" data-type=\"LOGIN/leftbanner/1\"><img src=\"/media/news/Sky 1_2.jpeg\" alt=\"\"></a></div></div><div class=\"col col12\"><div class=\"login-main\"><div class=\"login-logo\"><img src=\"/assets/img/logo-big.png\" alt=\"youtravel.com\"></div><div class=\"login-slogan\">The trades favorite hotel provider, going further for YOU.</div><form action=\"/reset-password\" id=\"forgot-password\" method=\"post\" class=\"hashlink\" data-parsley-validate=\"\" data-ajax-submit=\"\"><div class=\"login-form\"><div class=\"col4 auto-centered\"><div style=\"height: 49px;\"><div class=\"error-message pad-top-20 submit-error-text\">An error occured.</div></div><div class=\"field field-iconed field-iconed-right\"><span class=\"field-ico email-ico\"></span><span class=\"field-ico-right\"><span class=\"horizontal-mask\"><span class=\"tick-green-ico\"></span></span></span><input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Email address\" required=\"\"><div class=\"popover right info-popover-frame\"><div class=\"arrow\"></div><div class=\"popover-content\"><div class=\"header\">Forgot password</div><div class=\"content\">Please enter your email address and our sales team will be in touch with you shortly to retrieve your password.</div></div></div></div><button class=\"btn btn-big btn-block btn-send-link btn-loader\">Send</button><div class=\"text-right\"><a href=\"/register\" class=\"btn-unstyled btn-anchor small register-button\" data-modal-link=\"\" data-modal-preserve=\"\">Not a member? Sign up!</a><a class=\"btn-unstyled btn-anchor small left\" href=\"#\">&lt;&lt; BACK</a></div></div></div></form><form action=\"/adminlogin\" method=\"post\" id=\"admin-login\" class=\"hashlink\" autocomplete=\"off\" data-parsley-validate=\"\"><div class=\"login-form\"><div class=\"col4 auto-centered\"><div class=\"field field-iconed field-iconed-right\"><input class=\"form-control\" name=\"authcode\" placeholder=\"Secret code\" id=\"authcode\" required=\"\"><span class=\"field-ico lock-ico\"></span><span class=\"field-ico-right\"><span class=\"horizontal-mask\" id=\"authcode-tick\"><span class=\"tick-green-ico\"></span></span></span><div class=\"popover right error-popover-frame mrg-top-5\" id=\"authcode-error\" style=\"display: none\"><div class=\"arrow\"></div><div class=\"popover-content\"><span class=\"error-info-ico\"></span>Invalid authorization code.</div></div></div><div class=\"field field-iconed has-popover\"><select class=\"form-control hide-error-message\" name=\"agentId\" required=\"\" id=\"admin-login-agent\" disabled=\"\"><option value=\"\">Select tour operator</option></select><span class=\"field-ico user-ico\"></span></div><button class=\"btn btn-big btn-block btn-orange btn-loader\">Admin login</button><div class=\"clearfix\"><a class=\"btn-unstyled btn-anchor small left\" href=\"#\">&lt;&lt; BACK</a><div class=\"right error-message submit-error submit-error-text\"></div></div></div></div></form><form method=\"post\" id=\"login-form\" data-parsley-validate=\"\" data-add-submit-classes=\"\"><div class=\"login-form rel\"><div class=\"col4 auto-centered\"><div class=\"field field-iconed\"><span class=\"field-ico user-ico\"></span><input name=\"username\" class=\"form-control\" value=\"\" placeholder=\"Username\" required=\"\"></div><div class=\"field field-iconed\"><span class=\"field-ico lock-ico\"></span><input name=\"password\" type=\"password\" class=\"form-control\" placeholder=\"Password\" required=\"\"></div><button class=\"btn btn-big btn-main btn-block btn-loader\">Login</button><div class=\"clearfix\"><a href=\"#forgot-password\" class=\"btn-unstyled btn-anchor small right\">forgot password?</a></div></div></div></form></div><div class=\"login-slider slider swiper-container\"><ul class=\"swiper-wrapper\"><li class=\"swiper-slide\" style=\"height: 240px\"><div class=\"bnr\"><img src=\"/media/news/Slider 1.jpg\" alt=\"\"></div></li><li class=\"swiper-slide\" style=\"height: 240px\"><div class=\"bnr bordered\"><img src=\"/media/news/43c3f22a-018e-40c3-b41d-be64cbc546d6.jpeg\" alt=\"\"></div></li><li class=\"swiper-slide\" style=\"height: 240px\"><div class=\"bnr bordered\"><a class=\"bnr-lnk\" data-value=\"HOTEL:4401\" href=\"/hoteldetailsr.asp?hid=4401\" target=\"_blank\" data-search-hid=\"4401\" data-type=\"LOGIN/sliderbanners/3\"><img src=\"/media/news/b5fc6735-146d-409c-ba43-e4295615fd0a.jpeg\" alt=\"\"></a></div></li><li class=\"swiper-slide\" style=\"height: 240px\"><div class=\"bnr bordered\"><a href=\"/mpages/world-travel-market-2018\" data-value=\"MPAGE:world-travel-market-2018\" data-type=\"LOGIN/sliderbanners/4\"><img src=\"/media/news/709e8e33-a81e-42fc-8077-d914176736a4.png\" alt=\"\"></a></div></li></ul><div class=\"swiper-pagination\"></div><button type=\"button\" class=\"swiper-button-prev\"></button><button type=\"button\" class=\"swiper-button-next\"></button></div></div><div class=\"col col2\"><div class=\"bnr bordered\"><a class=\"bnr-lnk\" data-value=\"HOTEL:19113\" href=\"/hoteldetailsr.asp?hid=19113\" target=\"_blank\" data-search-hid=\"19113\" data-type=\"LOGIN/rightbanner/1\"><img src=\"/media/news/35355d71-8967-47cd-a22c-f5c19e35c22e.jpg\" alt=\"\"></a></div></div></div></section></div><footer class=\"footer\" id=\"footer\"><div class=\"wrapper\"><div class=\"clearfix\"><div class=\"left\">2018  &copy; Youtravel.com</div><nav class=\"right footer-links-wrap\"><a class=\"footer-link\" href=\"http://vouchers.youtravel.com/extranet.asp\">extranet</a>|<a class=\"footer-link\" href=\"/login#admin-login\">admin login</a>|<a class=\"footer-link\" href=\"/privacy-policy\">privacy policy</a>|<a class=\"footer-link\" href=\"/booking-conditions\">booking conditions</a>|<a class=\"footer-link\" href=\"/terms-and-conditions\">terms and conditions</a>|<a class=\"footer-link\" href=\"/travel-advice\">travel advice</a></nav></div></div></footer><script src=\"https://cdn.jsdelivr.net/npm/classlist-polyfill@1.2.0/src/index.min.js\"></script><script src=\"https://www.promisejs.org/polyfills/promise-7.0.4.min.js\"></script><script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.1/moment.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-date-range-picker/0.16.4/jquery.daterangepicker.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.sticky/1.0.4/jquery.sticky.min.js\"></script><script src=\"https://cdn.jsdelivr.net/npm/menuspy@1.3.0/dist/menuspy.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/parsley.js/2.8.1/parsley.min.js\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.2.6/js/swiper.min.js\"></script><script src=\"/assets/bundle.js?v=f57cc2cee632b9038113e5e546c5f32d571a9f2e\"></script><script src=\"https://maps.google.com/maps/api/js?key=&amp;callback=gmapcb\" async=\"\" defer=\"\"></script><script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-1210644-1', 'auto');ga('send', 'pageview');</script></div></div><script src=\"https://www.google.com/recaptcha/api.js?render=explicit\" async=\"\" defer=\"\"></script></body></html>";
        new OutIndent(System.out).write(xml.getBytes());


    }
}