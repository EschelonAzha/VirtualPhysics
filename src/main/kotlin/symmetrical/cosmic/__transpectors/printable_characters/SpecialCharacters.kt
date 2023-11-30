package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class SpecialCharacters : Characters {

    companion object {
        const val SPECIAL: String = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~"
    }
    constructor() : super() {
    }

    fun i() : SpecialCharacters {
        super.i(SPECIAL);
        return this;
    }
}