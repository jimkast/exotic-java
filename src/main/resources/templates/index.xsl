<xsl:stylesheet exclude-result-prefixes="#all" version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
    <xsl:output method="html" indent="no" encoding="utf-8" version="5"/>
    <xsl:strip-space elements="*"/>

        <xsl:template match="@*|node()">
            <xsl:copy>
                <xsl:apply-templates select="@*|node()"/>
            </xsl:copy>
        </xsl:template>
</xsl:stylesheet>