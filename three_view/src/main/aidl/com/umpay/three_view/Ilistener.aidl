// Ilistener.aidl
package com.umpay.three_view;
import com.umpay.three_view.Book;
// Declare any non-default types here with import statements

interface Ilistener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
void onBookReceiver(Book book);

}
