package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.*

open class SpinOld(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(SpinOld::class, SpinOld::class),
) :
    IMatterAntiMatter by matterAntiMatter,
    IEmitter
{
    constructor() : this(
        MatterAntiMatter(SpinOld::class, SpinOld::class),
    )

    object Static {
        const val PLUS :Int      = +1
        const val MINUS:Int      = -1
    }

    val spin:QuantumField = QuantumField(SpinOld.Static.PLUS)



    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()  // spin has no fields, we only need to know the
                             // type of spin
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun isPlus() : Boolean {
        return spin.getField().toInt() > 0
    }
    fun isMinus() : Boolean {
        return spin.getField().toInt() < 0
    }

    fun setSpin(value:Int) : SpinOld {
        spin.setValue(value)
        return this
    }

    fun spinPlus() : SpinOld {
        spin.setValue(SpinOld.Static.PLUS)
        return this
    }
    fun spinMinus() : SpinOld {
        spin.setValue(Static.MINUS)
        return this
    }
}