package symmetrical.dom.dom

import asymmetrical.machine.dom.Document
import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
import symmetrical.dom.Dom

open class Body(
    private val matter: IMatter = Matter(Body::class, Body::class),
) : Dom(),
    IMatter by matter
{
    constructor() : this(
        Matter(Body::class, Body::class),
    )

    val peer: HtmlPeer = HtmlPeer(Document.getElementById("body"))


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
}