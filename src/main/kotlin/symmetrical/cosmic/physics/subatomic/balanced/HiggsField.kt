package symmetrical.cosmic.physics.subatomic.balanced

/*
https://en.wikipedia.org/wiki/Higgs_boson#Higgs_field
 */

open class HiggsField{
    constructor()
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            HiggsField.Companion.higgsField = higgs
            return higgs
        }
    }

    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}