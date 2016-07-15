-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2016 at 12:55 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blog`
--
CREATE DATABASE IF NOT EXISTS `blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `blog`;

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `title` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `title`, `content`, `date`, `user_id`) VALUES
(1, 'Work Begins on HTML5.1', '<p>The World Wide Web Consortium (W3C) has begun work on <b>HTML5.1</b>, and this time it is handling the creation of the standard a little differently. The specification has its <b><a href="https://w3c.github.io/html/">own GitHub project</a></b> where anyone can see what is happening and propose changes.</p>\r\n\r\n<p>The organization says the goal for the new specification is "to <b>match reality better</b>, to make the specification as clear as possible to readers, and of course to make it possible for all stakeholders to propose improvements, and understand what makes changes to HTML successful."</p>\r\n\r\n<p>Creating HTML5 took years, but W3C hopes using GitHub will speed up the process this time around. It plans to release a candidate recommendation for HTML5.1 by <b>June</b> and a full recommendation in <b>September</b>.</p>\r\n', '2016-05-22 10:13:37', 2),
(2, 'Windows 10 Preview with Bash Support Now Available', '<p>Microsoft has released a new <b>Windows 10 Insider Preview</b> that includes native support for <b>Bash running on Ubuntu Linux</b>. The company first announced the new feature at last week''s Build development conference, and it was one of the biggest stories of the event. The current process for installing Bash is a little complication, but Microsoft has a blog post that explains how the process works.</p>\r\n\r\n<p>The preview build also includes <b>Cortana</b> upgrades, extensions support, the new <b>Skype</b> Universal Windows Platform app and some interface improvements.</p>', '2016-05-20 11:18:26', 8),
(3, 'Atom Text Editor GetsNew Windows Features', '<p>GitHub has released <b>Atom 1.7</b>, and the updated version of the text editor offers improvements for Windows developers. Specifically, it is now easier to build in Visual Studio, and it now supports the Appveyor CI continuous integration service for Windows.</p>\r\n\r\n<p>Other new features include improved tab switching, tree view and crash recovery. GitHub noted, "Crashes are nobody''s idea of fun, but in case Atom does crash on you, it periodically saves your editor state. After relaunching Atom after a crash, you should find all your work saved and ready to go."</p>\r\n\r\n<p>GitHub has also released a beta preview of Atom 1.8.</p>\r\n', '2016-05-07 11:21:21', 3),
(4, 'SoftUni 3.0 Launched', '<p>The <b>Software University (SoftUni)</b> launched a new training methodology and training program for software engineers in Sofia.</p>\r\n\r\n<p>It is a big step ahead. Now SoftUni offers several professions:</p>\r\n<ul>\r\n  <li>PHP Developer</li>\r\n  <li>JavaScript Developer</li>\r\n  <li>C# Web Developer</li>\r\n  <li>Java Web Developer</li>\r\n</ul>\r\n', '2016-04-07 11:25:40', 2),
(5, 'Git 2.8 Adds Security and Productivity Features', '<p>Version 2.8 of the open-source distributed version-control system Git has been released. The new edition provides a variety of new features, bugfixes and other improvements.</p>\r\n\r\n<p>According to GitHub, the most notable new features include:</p>\r\n\r\n<ul>\r\n<li><strong>Parallel fetches of submodules:</strong> “Using ‘git submodules,’ one Git repository can include other Git repositories as subdirectories. This can be a useful way to include libraries or other external dependencies into your main project. The top-level repository specifies which submodules it wants to include, and which version of each submodule,” wrote Jeff King, a Git team member, in a <a href="https://github.com/blog/2131-git-2-8-has-been-released">blog post</a>. According to him, if users have multiple submodules, fetches can be time-consuming. The latest release allows users to fetch from multiple submodules in parallel.</li>\r\n<li><strong>Don’t guess my identity: </strong>Instead of using one e-mail address for all of a user’s open-source projects, they can now tell Git what user name and e-mail they want to use before they commit.</li>\r\n<li><strong>Convergences with Git for Windows:</strong> The Git team has been working on making Git as easy to work with on Windows as it is on Linux and OS X. The latest release includes Git commands rewritten in C; Windows-specific changes from the Git for Windows project; and the ability to accept both LF and CRLF line endings. “This continuing effort will make it easier to keep the functionality of Git in sync across platforms as new features are added,” King wrote.</li>\r\n<li><strong>Security fixes: </strong>Git 2.8 addresses the vulnerability CVE-2016-2324. There have not been any reported exploits, but the vulnerability could execute arbitrary code when cloning a malicious repository, according to King.</li>\r\n</ul>\r\n\r\n<p>Other features include the ability to turn off Git’s clean and smudge filters; the ability to see where a particular setting came from; the ability to easily diagnose end-of-line problems; the ability to see a remote repository’s default branch; and support for cloning via the rsync protocol has been dropped.</p>\r\n\r\n<p>The full release notes are available <a href="https://github.com/git/git/blob/v2.8.0/Documentation/RelNotes/2.8.0.txt">here</a>.</p>\r\n', '2016-01-17 11:27:50', 5),
(6, 'Rogue Wave Updates Zend Framework', '<p>Rogue Wave is updating its open-source framework for developing Web applications and services. According to the company, this is the first major release in four years. Zend Framework 3 features support for PHP 7, middleware runtime and performance enhancements.</p>\r\n\r\n<p>The newly released support for PHP 7 aims to simplify how developers create, debug, monitor and deploy modern Web and mobile apps in PHP 7. “This is an exciting time to be a PHP developer,” said Zeev Suraski, cofounder of Zend and CTO of Rogue Wave. “With Zend Framework 3, we’re continuing our quest to make creating PHP applications simpler, more accessible and faster.”</p>\r\n\r\n<p>In addition, version 3 of the framework features an architectural structure that allows developers to use components within Zend Framework apps or any other framework in order to reduce dependencies, and to enable reuse within the PHP ecosystem.</p>\r\n\r\n<p>Another key update to the solution is a new middleware runtime. Expressive is designed to focus on simplicity and interoperability, and it enables developers to customize their solutions.</p>\r\n\r\n<p>“I’m extremely proud of the work we’ve done with Expressive,” said Matthew Weier O’Phinney, principal engineer and Zend Framework project lead at Rogue Wave. “Expressive signals the future of PHP applications, composed of layered, single-purpose PSR-7 middleware.”</p>\r\n', '2015-11-22 11:57:40', 5),
(10, 'Good Morning', 'Blog is ready!', '2016-07-12 04:17:29', 9),
(12, 'Creating a Blog with PHP and MySQL', 'This document holds a step-by-step tutorial on how to create a Blog system based on <strong>PHP, Apache</strong> and <strong>MySQL</strong> with a simple custom <strong>MVC framework</strong>. This lab exercise is part of the <a href="https://softuni.bg/trainings/1390/software-technologies-june-2016">“Software Technologies” course @ SoftUni</a>.', '2016-07-12 04:20:10', 9);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_hash` varchar(100) DEFAULT NULL,
  `full_name` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password_hash`, `full_name`) VALUES
(1, 'admin', '$2y$10$QlKthcuYhn.XP/gy5A/OZeQdOzIznqxqOf/qBrSAnGpoW4labIL0W', NULL),
(2, 'nakov', '$2y$10$XViubT.zSoBtskZmKl6kdOX8Yq7T7tLrcrLn/5dkAqbgjVACeFUGe', 'Svetlin Nakov'),
(3, 'maria', '$2y$10$gzlpX/N5apTruTBajMJwM.0h9OgLVgQxk6N0YhGy2iY4BI73SYkKO', 'Maria Ivanova'),
(4, 'ani', '$2y$10$9T9bN6ctJ4R.fdnLvzsdQOj0sk4mWqwohILMx60/jP1YEXtJguhD2', 'Ani Kirova'),
(5, 'joe', '$2y$10$aIOC0qiNK1mjZdUUbuj/Teh49VI/g9xanuWCNYEUruwcvOGVaXOGK', 'Joe Green'),
(6, 'test', '$2y$10$I5y7X1ZilitEZYOztOI5SuA2rBeRJUj/ZhlgmSZK32LPqaqh3Gy3q', ''),
(7, 'it''s security "test"<br>', '$2y$10$thSx6ceSyCPxdl.BDGLhKe7lQu8d3oopQ/LJYK8ma.Dz6jWbOgj8C', 'it''s security "test"<br>'),
(8, 'vikash', '$2y$10$Exc5mMcThOlEnXZ2.kAPl.ouBSDl8S0GjD.3vvB6KohMpcgfsLsde', 'Vikash Jain'),
(9, 'anna', '$2y$10$otEnfS6TwQn/uEiJPNLdGuzRSouRnASH6gOlf.Bwr5izzUxXUPZ5S', 'Anna Stambolieva'),
(12, '<script></script>', '$2y$10$38KbEuInr84lEyNNjVxsjuky2UrjXLrs0r/qm3.JT6yV9QczX.Soq', 'Script'),
(13, 'SoftUni', '$2y$10$dWZVMuam93g9r9k/mj3uB.0l6A4WWD0s/dAU.R1aywZ6xzAa33y9.', 'Software University'),
(14, 'economist', '$2y$10$fD/gSdiZ7RCiclBoLd/MCOjMuFKVTIfWcJ/WNM8ae1qpPPwdqsOUW', 'The Economist');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_posts_idx` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `fk_users_posts` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
