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
        String xml = "<xsl:stylesheet exclude-result-prefixes=\"#all\" version=\"2.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:local=\"http://www.w3.org/2005/xquery-local-functions\"><xsl:template match=\"rsp[@id='hotel-detail-tabs']\" mode=\"layout\"><xsl:apply-templates select=\"HtSearchRq/Hotel\" mode=\"hotel-tabs-content\"/></xsl:template><xsl:template match=\"Hotel\" mode=\"hotel-tabs-head\"><div class=\"search-item-buttons-row search-item-extra-bordered-sec clearfix\" data-tabs-closable=\"\" data-hotel-tabs=\"{@ID|@id|../HID}\"><button type=\"button\" class=\"fat-link dropdown-btn tab-select left htab\">HOTEL DETAILS</button><button type=\"button\" class=\"fat-link dropdown-btn tab-select left htab\" data-images-button=\"{@ID|@id|../HID}\">IMAGES</button><button type=\"button\" class=\"fat-link dropdown-btn tab-select left htab\" data-location-button=\"{@ID|@id|../HID}\">LOCATION</button><xsl:variable name=\"ai_type\" select=\"(AI_Type[.!=''], *[starts-with(name(), 'Room_')]/Room/AI_Type)[1]\"/><xsl:if test=\"$ai_type\"><div class=\"rel inblock has-popover has-popover-sibling left\"><button type=\"button\" data-index=\"3\" class=\"fat-link dropdown-btn tab-select ai-fat-link\"><xsl:apply-templates select=\"$ai_type\" mode=\"ai-icon\"/></button><xsl:apply-templates select=\"$ai_type\" mode=\"ai-popup\"/></div></xsl:if></div></xsl:template><xsl:template match=\"Hotel\" mode=\"hotel-tabs-content\"><div class=\"hotel-item-tabs-cnt\"><div class=\"search-item-extra-cnt search-item-extra-bordered-sec\"><div class=\"tabs-row\" data-tabs=\"\"><button type=\"button\" class=\"btn-link active\">DESCRIPTION</button><button type=\"button\" class=\"btn-link\">FACILITIES</button><button type=\"button\" class=\"btn-link\">ERRATAS</button><button type=\"button\" class=\"btn-link\">ROOM TYPES</button></div><div><div class=\"editor grey-title-small pad-top-10\"><div class=\"prewrap\"><xsl:value-of disable-output-escaping=\"yes\" select=\"local:clean-html(Hotel_Desc)\"/></div></div><div class=\"editor grey-title-small pad-top-10\" style=\"display: none\"><ul><xsl:for-each select=\"Hotel_Facilities/Facility\"><li><xsl:value-of select=\".\"/></li></xsl:for-each></ul></div><div class=\"editor grey-title-small pad-top-10\" style=\"display: none\"><div class=\"prewrap\"><xsl:value-of disable-output-escaping=\"yes\" select=\"local:clean-html(Erratas)\"/></div></div><div class=\"editor grey-title-small pad-top-10\" style=\"display: none\"><xsl:for-each select=\"Room_Types/Room\"><h4 class=\"line-after\"><span><xsl:value-of select=\"@name\"/></span></h4><ul><xsl:for-each select=\"Facility\"><li><xsl:value-of select=\".\"/></li></xsl:for-each></ul></xsl:for-each></div></div></div><div class=\"search-item-extra-cnt search-item-extra-bordered-sec\"><div class=\"gallery\" data-gallery=\"\"><div class=\"swiper-container gallery-top\"><ul class=\"swiper-wrapper\"><xsl:for-each select=\"Hotel_Photos/Photo\"><li class=\"swiper-slide\"><img src=\"{.}\"/></li></xsl:for-each></ul><button type=\"button\" class=\"swiper-button-prev black\"/><button type=\"button\" class=\"swiper-button-next black\"/></div><div class=\"swiper-container gallery-thumbs\"><ul class=\"swiper-wrapper\"><xsl:for-each select=\"Hotel_Photos/Photo\"><li class=\"swiper-slide\"><img src=\"{.}\" style=\"width: 180px; height: 144px;\" width=\"180\" height=\"144\"/></li></xsl:for-each></ul></div></div></div><div class=\"search-item-extra-cnt search-item-extra-bordered-sec\"><div class=\"map-wrap gmap-lazy\" style=\"height: 484px;\"\n" +
            "                     data-hotel-map=\"{@ID|@id|../HID}\"\n" +
            "                     data-lat=\"{../../hotel-extras/lat}\"\n" +
            "                     data-lng=\"{../../hotel-extras/lng}\"\n" +
            "                     data-name=\"{local:clean-invalid-html(@Name)}\"\n" +
            "                     data-zoom=\"18\"/></div><xsl:if test=\"AI_Desc\"><div class=\"search-item-extra-cnt search-item-extra-bordered-sec\"><div class=\"editor grey-title-small\"><xsl:if test=\".!=''\"><h4 class=\"line-after\" rv-show=\"ctrl.details.aiDescription | trim\"><span>ALL INCLUSIVE DESCRIPTION</span></h4><div class=\"prewrap\"><xsl:value-of disable-output-escaping=\"yes\" select=\"AI_Desc\"/></div></xsl:if><h4 class=\"line-after\"><span>ALL INCLUSIVE FACILITIES</span></h4><ul><xsl:for-each select=\"AI_Facilities/AI_Facility\"><li><xsl:value-of select=\".\"/></li></xsl:for-each></ul></div></div></xsl:if></div></xsl:template></xsl:stylesheet>";
        new OutIndent(System.out).write(xml.getBytes());


    }
}