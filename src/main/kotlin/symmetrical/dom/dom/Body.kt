package symmetrical.dom.dom

import asymmetrical.machine.dom.Document
import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement
import symmetrical.dom.Dom

open class Body(
    private val fermion: IQuantumEntanglement = QuantumEntanglement()
) : Dom(),
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )
    val peer: HtmlPeer = HtmlPeer(Document.getElementById("body"))



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
        return Absorber.getClassId(Body::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
}