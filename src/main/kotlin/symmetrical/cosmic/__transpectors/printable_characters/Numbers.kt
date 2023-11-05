package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class Numbers : Characters {

    companion object {
        const val NUMBERS: String = "01234567890";
    }
    constructor() : super() {
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Numbers::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Numbers {
        super.i(NUMBERS);
        return this;
    }
}