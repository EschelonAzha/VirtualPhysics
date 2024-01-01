package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
/*
https://en.wikipedia.org/wiki/Higgs_boson#Higgs_field
 */

open class HiggsField{
    constructor()
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }

    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}