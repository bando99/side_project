package com.inProject.in.Global.exception;

public class ConstantsClass{
    public enum ExceptionClass{
        USER("User"),
        BOARD("Board"),
        COMMENT("Comment"),
        APPLICATION("Application"),
        PROFILE("Profile"),
        SIGN("Sign"),
        FIND("Find"),
        CHANGE("Change"),
        Clip("Clip");

        private String exceptionClass;

        ExceptionClass(String exceptionClass){
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass(){
            return exceptionClass;
        }

        @Override
        public String toString(){
            return getExceptionClass() + " Exception. ";
        }
    }
}