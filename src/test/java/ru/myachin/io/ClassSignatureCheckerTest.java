package ru.myachin.io;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;

public class ClassSignatureCheckerTest {

    @Test
    public void testValidClassSignature() throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(".", ".*\\.class");
        for (File file : treeInfo) {
            assertTrue(ClassSignatureChecker.isValidClassSignature(BinaryFile.read(file)));
        }
    }

    @Test
    public void testInvalidClassSignature() throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(".", ".*\\.java");
        for (File file : treeInfo) {
            assertFalse(ClassSignatureChecker.isValidClassSignature(BinaryFile.read(file)));
        }
    }
}