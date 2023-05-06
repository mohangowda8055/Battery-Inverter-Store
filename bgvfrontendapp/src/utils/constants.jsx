import React from "react";
import {
  FaBehance,
  FaFacebook,
  FaLinkedin,
  FaTwitter,
  FaSketch,
  FaHome,
  FaUserFriends,
  FaFolderOpen,
  FaCalendarAlt,
  FaWpforms,
} from "react-icons/fa";

export const pincodes = [560059, 560090];

export const links = [
  {
    id: 1,
    url: "/",
    text: "home",
    icon: <FaHome />,
  },
  {
    id: 2,
    url: "/team",
    text: "team",
    icon: <FaUserFriends />,
  },
  {
    id: 3,
    url: "/projects",
    text: "projects",
    icon: <FaFolderOpen />,
  },
  {
    id: 4,
    url: "/calendar",
    text: "calendar",
    icon: <FaCalendarAlt />,
  },
  {
    id: 5,
    url: "/documents",
    text: "documents",
    icon: <FaWpforms />,
  },
];

export const services = [
  { label: "Two Wheelers", url: "/products" },
  { label: "Three Wheelers", url: "/products" },
  { label: "Four Wheelers", url: "/products" },
  { label: "Inverters", url: "/products" },
  { label: "Inverter Battery", url: "/products" },
  { label: "Others", url: "/products" },
];

export const social = [
  {
    id: 1,
    url: "https://www.twitter.com",
    icon: <FaFacebook />,
  },
  {
    id: 2,
    url: "https://www.twitter.com",
    icon: <FaTwitter />,
  },
  {
    id: 3,
    url: "https://www.twitter.com",
    icon: <FaLinkedin />,
  },
  {
    id: 4,
    url: "https://www.twitter.com",
    icon: <FaBehance />,
  },
  {
    id: 5,
    url: "https://www.twitter.com",
    icon: <FaSketch />,
  },
];
