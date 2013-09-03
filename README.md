conversion
==========
利用RobeGuice实现的一个简单的单位换算的小应用。
支持Maven。
添加Repository
<repositories>
  <repository>
    <id>sonatype-nexus-snapshots</id>
    <name>Sonatype Nexus Snapshots</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    <releases>
      <enabled>false</enabled>
    </releases>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>goodow-realtime</id>
    <name>Goodow Realtime Maven Repository</name>
    <url>https://raw.github.com/goodow/maven/master/repositories/realtime/</url>
    <snapshots>
      <enabled>false</enabled>
    </snapshots>
  </repository>
</repositories>
