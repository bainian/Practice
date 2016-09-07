package com.umpay.three_view;

interface ServerLinstener {

    List<String> gotList(String name);

    int clac(int a, int b);

    void addListener(Ilistener listener);

    void removeListener(Ilistener listener);

}