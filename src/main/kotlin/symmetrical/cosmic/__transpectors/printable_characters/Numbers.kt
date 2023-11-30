package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class Numbers : Characters {

    companion object {
        const val NUMBERS: String = "01234567890";
    }
    constructor() : super() {
    }

    fun i() : Numbers {
        super.i(NUMBERS);
        return this;
    }
}