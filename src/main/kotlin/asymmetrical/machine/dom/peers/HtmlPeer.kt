package asymmetrical.machine.dom.peers

import asymmetrical.machine.dom.Document
import asymmetrical.machine.dom.Element

import symmetrical.dom.dom.peers.DomPeer


class HtmlPeer : DomPeer {
    private lateinit var peer: Element;
    constructor() {
    }
    constructor(peer:Element) {
        this.peer = peer
    }
    override fun attachElement(id:String) : DomPeer {
        val peer = Document.getElementById(id)
        this.peer = peer as Element
        return this
    }
    override fun createElement   (type:String)   : DomPeer {
        this.peer = Document.createElement(type)
        return this
    }

}