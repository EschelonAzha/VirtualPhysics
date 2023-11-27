package symmetrical.dom.dom

import asymmetrical.machine.dom.Document
import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.dom.Dom

open class Body(
    private val antiMatter: IAntiMatter = AntiMatter(Body::class),
) : Dom(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(Body::class),
    )

    val peer: HtmlPeer = HtmlPeer(Document.getElementById("body"))


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}