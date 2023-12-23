package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin
import symmetrical.cosmic.__recycle.Absorber
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

    val field:QuantumField = QuantumField(SpinOld.Static.PLUS)

    override fun absorb(photon: Photon) : Photon {
        return field.absorb(photon.propagate());
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(SpinOld::class)
    }

//    override fun absorb(photon: Photon) : Photon {
//        matterAntiMatter.check(photon);
//
//        return photon.propagate()
//    }
//    override fun emit() : Photon {
//        return Photon(radiate())
//    }
//    private fun radiate() : String {
//        return matterAntiMatter.getClassId()
//
//    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun isPlus() : Boolean {
        return field.getField().toInt() > 0
    }
    fun isMinus() : Boolean {
        return field.getField().toInt() < 0
    }

    fun setSpin(value:Int) : SpinOld {
        field.setValue(value)
        return this
    }

    fun spinPlus() : SpinOld {
        field.setValue(SpinOld.Static.PLUS)
        return this
    }
    fun spinMinus() : SpinOld {
        field.setValue(Static.MINUS)
        return this
    }
}