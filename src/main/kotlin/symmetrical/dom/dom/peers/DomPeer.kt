package symmetrical.dom.dom.peers


interface DomPeer {
    fun attachElement   (id:String)     : DomPeer
    fun createElement   (type:String)   : DomPeer


}