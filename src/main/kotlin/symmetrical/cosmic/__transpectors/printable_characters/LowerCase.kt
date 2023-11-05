package symmetrical.cosmic.__transpectors.printable_characters

import symmetrical.cosmic.__recycle.Absorber

class LowerCase : Characters {

    companion object {
        const val LOWERCASE: String = "abcdefghijklmnopqrstuvwxyz";
    }
    constructor() : super() {
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(LowerCase::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : LowerCase {
        super.i(LOWERCASE);
        return this;
    }
}