package symmetrical.cosmic._physics.atomic.substance.ions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.ionic.Ionic
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class Compound(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) : Molecular(),
    IQuantumEntanglement by entanglement,
    Ionic
{
    constructor() : this(
        QuantumEntanglement()
    )
    object Static {
        const val LAST      : Int = -1
    }


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

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        val (molecularId, remainder) = Strings.remainder(2, super.emit().radiate())
        return getLocalClassId()+remainder
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Compound::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }

    override fun i() : Compound {
        super.i();
        return this
    }
}