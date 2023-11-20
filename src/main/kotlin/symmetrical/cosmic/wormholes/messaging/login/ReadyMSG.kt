package symmetrical.cosmic.wormholes.messaging.login


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class ReadyMSG (
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Message(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }

    override fun i() : ReadyMSG {
        super.i()
        return this
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
        return Absorber.getClassId(ReadyMSG::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}