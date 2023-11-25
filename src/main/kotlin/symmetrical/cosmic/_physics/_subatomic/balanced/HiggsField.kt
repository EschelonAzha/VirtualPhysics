package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class HiggsField(
    private val luminescent: ILuminescent = Luminescent(HiggsField::class),
) : Energy(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(HiggsField::class),
    )
    // Spin 0
    companion object {
        lateinit var higgsField : HiggsField

        fun setForce(higgs: HiggsField) : HiggsField {
            higgsField = higgs
            return higgs
        }
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}