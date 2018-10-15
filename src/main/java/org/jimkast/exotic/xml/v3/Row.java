package org.jimkast.exotic.xml.v3;

import org.jimkast.exotic.binary.binary;

public interface Row {
    int single(int i);

    binary binary(int i);

    int length();


    Row UNKNOWN = new Row() {
        @Override
        public int single(int i) {
            return 0;
        }

        @Override
        public binary binary(int i) {
            return binary.EMPTY;
        }

        @Override
        public int length() {
            return 0;
        }
    };

    DirRowSingle INDEX = new DirRowSingle.ByNum(0);
    DirRowSingle DEPTH = new DirRowSingle.ByNum(3);
    DirRowSingle TYPE = new DirRowSingle.ByNum(2);
    DirRowSingle PARENT = new DirRowSingle.ByNum(1);
    DirRowBinary NAME = new DirRowBinary.ByNum(4);
    DirRowBinary CONTENT = new DirRowBinary.ByNum(5);
}
