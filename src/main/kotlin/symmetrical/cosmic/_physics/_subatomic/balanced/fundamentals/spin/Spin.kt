package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class Spin(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement(),
) : Particle(entanglement),
    IQuantumEntanglement by entanglement,
    Emitter
{
    constructor() : this(
        QuantumEntanglement()
    ) {
    }

    object Static {
        const val PLUS :Int      = +1
        const val MINUS:Int      = -1
    }

    val field:Field = Field(Spin.Static.PLUS)


    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
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
        return getLocalClassId()  // spin has no fields, we only need to know the
                             // type of spin
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Spin::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    fun isPlus() : Boolean {
        return field.toInt() > 0
    }
    fun isMinus() : Boolean {
        return field.toInt() < 0
    }

    fun setSpin(value:Int) : Spin {
        field.setValue(value)
        return this
    }

    fun spinPlus() : Spin {
        field.setValue(Spin.Static.PLUS)
        return this
    }
    fun spinMinus() : Spin {
        field.setValue(Static.MINUS)
        return this
    }
}