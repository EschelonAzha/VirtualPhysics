package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class UpperCase : Characters {

    companion object {
        const val UPPERCASE: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    constructor() : super() {
    }

    fun i() : UpperCase {
        super.i(UPPERCASE);
        return this;
    }
}