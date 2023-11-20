package symmetrical.cosmic._physics._subatomic.balanced.color

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class ChromoCharge(
    private val fermion: IFermion = Fermion(),
) : Particle(),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion()
    ) {}

    public var _value: Any? = null

    protected var color :Short = COLORLESS

    companion object {
        const val COLORLESS :Short   = 0
        const val RED       :Short   = 1
        const val BLUE      :Short   = 2
        const val GREEN     :Short   = 3
        const val ANTI_RED  :Short   = -1
        const val ANTI_BLUE :Short   = -2
        const val ANTI_GREEN:Short   = -3
    }


    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName);
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ChromoCharge::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : ChromoCharge {
        return this
    }
    fun isAntiGreen() : Boolean {
        return color == ANTI_GREEN
    }
    fun isAntiRed() : Boolean {
        return color == ANTI_RED
    }
    fun isAntiBlue() : Boolean {
        return color == ANTI_BLUE
    }
    fun isGreen() : Boolean {
        return color == GREEN
    }
    fun isRed() : Boolean {
        return color == RED
    }
    fun isBlue() : Boolean {
        return color == BLUE
    }


    fun reinitialize() : ChromoCharge {
        return this
    }
    open fun clone() : ChromoCharge {
        return ChromoCharge()
    }

    open fun getString() : String {
        return _value.toString()
    }
    fun setBaryon(baryon: Baryon) : ChromoCharge {
        // setQuark(baryon.quarks[0].value)
        return this
    }
//    fun setQuark(quark:Quark) : ChromoCharge {
//
//        quark.gluon.color = this as Color
//        return this
//    }

    fun setValue(value:Any?) : ChromoCharge {
        this._value = value
        return this
    }
}