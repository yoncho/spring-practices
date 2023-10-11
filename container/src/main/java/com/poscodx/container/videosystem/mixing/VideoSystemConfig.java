package com.poscodx.container.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *  _import_  <----- JavaConfig1, JavaConfig2
 * 
 * JavaConfig1 + JavaConfig2
 */
@Configuration
@Import({DVDConfig.class,DVDPlayerConfig.class})
public class VideoSystemConfig {
}
