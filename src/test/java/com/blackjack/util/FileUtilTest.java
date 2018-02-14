package com.blackjack.util;

import org.junit.Assert;
import org.junit.Test;


public class FileUtilTest {

    @Test
    public void fileToCards() {
        String filePath = this.getClass().getResource("/cards.txt").getPath();
        Assert.assertEquals(52, FileUtil.fileToCards(filePath).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyFilePathToCards() throws Exception {
        String filePath = "";
        FileUtil.fileToCards(filePath);
    }

}
