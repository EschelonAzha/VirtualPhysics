package symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiDown
import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent


open class NeutralDownPion(
    private val luminescent: ILuminescent = Luminescent(NeutralDownPion::class),
) : Hadron(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(NeutralDownPion::class),
    )   init {
        super.i(2)
        this.set(0, Down())
        this.set(1, AntiDown())
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
//    fun decay() : ElectronPositron {
//        return ElectronPositron().decay(this)
//    }
}