package symmetrical.dom.dom

import asymmetrical.machine.dom.Document
import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent
import symmetrical.dom.Dom

open class Body(
    private val luminescent: ILuminescent = Luminescent(Body::class),
) : Dom(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(Body::class),
    )

    val peer: HtmlPeer = HtmlPeer(Document.getElementById("body"))


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}