package com.mypackage.state;

import com.mypackage.Round;

// ToDo: rename prompt to something more appropriate.
public interface State {

    String createPrompt(Round round);
}
