package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class SpecialCharacters : Characters {

    companion object {
        const val SPECIAL: String = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~"
    }
    constructor() : super() {
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(UpperCase::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : SpecialCharacters {
        super.i(SPECIAL);
        return this;
    }
}