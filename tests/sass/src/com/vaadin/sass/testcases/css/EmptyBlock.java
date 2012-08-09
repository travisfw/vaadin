package com.vaadin.sass.testcases.css;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.css.sac.CSSException;

import com.vaadin.sass.AbstractTestBase;

public class EmptyBlock extends AbstractTestBase {
    String css = "/basic/empty_block.css";

    @Test
    public void testParser() throws CSSException, URISyntaxException,
            IOException {
        testParser(css);
        Assert.assertEquals("Original CSS and parsed CSS doesn't match",
                originalScss, parsedScss);
    }
}
