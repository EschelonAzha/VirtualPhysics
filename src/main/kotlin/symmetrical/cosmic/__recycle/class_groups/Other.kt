package symmetrical.cosmic.__recycle.class_groups

import asymmetrical.machine.dom.peers.HtmlPeer
import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.*
import symmetrical.cosmic._bitmaps.*
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._dimensions.time.Strobe
import symmetrical.cosmic._physics._dimensions.time.Time
import symmetrical.cosmic._physics._subatomic.balanced.HiggsField
import symmetrical.cosmic._physics._subatomic.balanced.Monad
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.bosons.HiggsBoson
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.matter.colors.manifestations.CRLFTerminatedColor
import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Solution
import symmetrical.cosmic._physics.atomic.matter.Material
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics.atomic.substance.metals.Metal
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic.dictionary.PasswordFld
import symmetrical.cosmic.dictionary.UseridFld
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.wormholes.messaging.login.AppendMSG
import symmetrical.cosmic.wormholes.messaging.login.LoginMSG
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG
import symmetrical.cosmic.wormholes.pulsar.dictionary.Host
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path
import symmetrical.cosmic.wormholes.pulsar.socket.Outlet
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage
import symmetrical.device.DeviceInput
import symmetrical.dom.Dom
import symmetrical.dom.DomProperties
import symmetrical.dom.DomProperty
import symmetrical.dom.dom.Body
import symmetrical.dom.properties.colors.BackgroundColor
import symmetrical.dom.properties.identification.DomId
import symmetrical.dom.properties.region.DomHeight
import symmetrical.dom.properties.region.DomLeft
import symmetrical.dom.properties.region.DomTop
import symmetrical.dom.properties.region.DomWidth
import symmetrical.dom.properties.style.DomStyle

class Other : ClassGroup {
    constructor() {

        add(EntityId(Base52.classId(), CRLFTerminatedColor::class))
        add(EntityId(Base52.classId(), CRLFTerminatedMomentum::class))
        add(EntityId(Base52.classId(), CrLfTerminatedString::class))
        add(EntityId(Base52.classId(), DeviceInput::class))
        add(EntityId(Base52.classId(), Host::class))
        add(EntityId(Base52.classId(), KeyValue::class))
        add(EntityId(Base52.classId(), Magnetism::class))
        add(EntityId(Base52.classId(), Matter::class))
        add(EntityId(Base52.classId(), Message::class))
        add(EntityId(Base52.classId(), Metal::class))
        add(EntityId(Base52.classId(), Monad::class))
        add(EntityId(Base52.classId(), Outlet::class))
        add(EntityId(Base52.classId(), PasswordFld::class))
        add(EntityId(Base52.classId(), Path::class))
        add(EntityId(Base52.classId(), SocketMessage::class))
        add(EntityId(Base52.classId(), Strobe::class))
        add(EntityId(Base52.classId(), Time::class))
        add(EntityId(Base52.classId(), UseridFld::class))


        /************************/
        add(EntityId(Base52.classId(), AppendMSG::class))
        add(EntityId(Base52.classId(), BackgroundColor::class))
        add(EntityId(Base52.classId(), Body::class))
        add(EntityId(Base52.classId(), Dom::class))
        add(EntityId(Base52.classId(), DomHeight::class))
        add(EntityId(Base52.classId(), DomId::class))
        add(EntityId(Base52.classId(), DomLeft::class))
        add(EntityId(Base52.classId(), DomStyle::class))
        add(EntityId(Base52.classId(), DomTop::class))
        add(EntityId(Base52.classId(), DomWidth::class))
        add(EntityId(Base52.classId(), DomProperties::class))
        add(EntityId(Base52.classId(), DomProperty::class))
        add(EntityId(Base52.classId(), HtmlPeer::class))
        add(EntityId(Base52.classId(), LoginMSG::class))
        add(EntityId(Base52.classId(), ReadyMSG::class))

    }
}