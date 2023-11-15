package symmetrical.cosmic._physics.atomic.bonds.covalent

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Diatomic(private val entanglement:QuantumEntanglement= QuantumEntanglement()) : Molecular(), IQuantumEntanglement by entanglement {

    object Static {
        const val LAST      : Int = -1
    }
    constructor() : this(QuantumEntanglement()) {
    }
    constructor(atom1: Atom, atom2:Atom) : this() {
        add(atom1)
        add(atom2)
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
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Diatomic::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}