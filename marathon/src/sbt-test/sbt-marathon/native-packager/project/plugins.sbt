resolvers += Resolver.bintrayRepo("jeffreyolchovy", "sbt-plugins")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.1")

{
  sys.props.get("plugin.version") match {
    case Some(pluginVersion) =>
      addSbtPlugin("com.tapad.sbt" % "sbt-marathon" % pluginVersion)
    case None =>
      sys.error(
        """
        |The system property 'plugin.version' is not defined.
        |Specify this property using the scriptedLaunchOpts -D.
        """.stripMargin.trim
      )
  }
}