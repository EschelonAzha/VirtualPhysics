package symmetrical.cosmic.wormholes.pulsar.socket

import symmetrical.cosmic._physics._subatomic.spatial.Beam

interface IOutlet {
    fun close()                     : IOutlet
    fun flush()                     : IOutlet
//    fun getClass()                  : String
    fun hasRecords()                : Boolean
    fun pop()                       : Any?
    fun read()                      : Int
    fun receiveRecords()            : Beam
    fun write(byteArray:ByteArray)  : Boolean
    fun write(item:String)          : Boolean

}