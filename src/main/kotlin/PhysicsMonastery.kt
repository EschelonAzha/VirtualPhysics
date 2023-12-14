
import asymmetrical.wormholes.pulsar.Pulsar
import symmetrical.cosmic.__recycle.Absorber

import symmetrical.cosmic._physics._subatomic.bosons.IEmitter

import symmetrical.cosmic.cosmology.INebula
import symmetrical.dom.Dom

import symmetrical.dom.properties.region.DomHeight
import websites.physics_monastery.PhysicsMonasteryGalaxy
import websites.physics_monastery.PhysicsMonasteryNebula
import kotlin.reflect.KClass


fun main(args: Array<String>) {
    val detector = Absorber.initialize()
    println("Start="+System.currentTimeMillis())
    for (i in 0 until 1) {
        test()
    }
    println("Stop ="+System.currentTimeMillis())

    Pulsar(PhysicsMonasteryGalaxy(), 9090, PhysicsMonasteryNebula::class as KClass<INebula>).start()
    println("Server Started on Port:9090 ...")
}

fun test() : Unit {
    val property = DomHeight(99999999)
    val child = Dom()
    val parent = Dom()
    parent.addProperty(property)
    parent.append(child)

    val emission = parent.emit().radiate()

    val (clone: IEmitter, remainder:String) = Absorber.materialize(emission)

    val dom:Dom = clone as Dom


    return
}