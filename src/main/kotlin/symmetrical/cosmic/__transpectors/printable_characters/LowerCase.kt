package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class LowerCase : Characters {

    companion object {
        const val LOWERCASE: String = "abcdefghijklmnopqrstuvwxyz";
    }
    constructor() : super() {
    }

    fun i() : LowerCase {
        super.i(LOWERCASE);
        return this;
    }
}