package com.findwise;

public class Term {

    private String term;

    private double tf;

    public Term(String term, double tf) {
        this.term = term;
        this.tf = tf;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getTf() {
        return tf;
    }

    public void setTf(double tf) {
        this.tf = tf;
    }
}
