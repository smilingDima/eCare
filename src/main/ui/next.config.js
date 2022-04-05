/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,

  // https://stackoverflow.com/questions/60925133/proxy-to-backend-with-default-next-js-dev-server
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: 'http://localhost:8080/api/:path*' // Proxy to Backend
      }
    ]
  }
}

module.exports = nextConfig
