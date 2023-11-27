package symmetrical.cosmic._physics._subatomic.balanced

import asymmetrical.machine.threads.Energy
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class HiggsField(
    private val antiMatter: IAntiMatter = AntiMatter(HiggsField::class),
) : Energy(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(HiggsField::class),
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
        return antiMatter.getClassId()
    }
    open fun materialize() : HiggsField {
        println("Higgs")
        return this
    }
}