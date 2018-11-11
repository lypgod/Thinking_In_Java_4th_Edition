package com.lypgod.test.tij4.practices.Ch12_ErrorHandlingWithExceptions.Practice21;

class ConstructionException extends Exception {
    ConstructionException(String msg) {
        super(msg);
    }
}
class Base {
    Base() throws ConstructionException {
        throw new ConstructionException("Base construction exception.");
    }
}
class Child extends Base {

    Child() throws ConstructionException {
        super();
    }
}
public class Practice21 {
}
