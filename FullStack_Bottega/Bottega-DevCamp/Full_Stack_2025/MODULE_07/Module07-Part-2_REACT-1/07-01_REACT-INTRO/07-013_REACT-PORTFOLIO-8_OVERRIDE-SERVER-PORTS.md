# 07-013: React Portfolio 8 - Overriding Server Ports

**Files**:

- `env.js` and `env.example.js` (configuration + example without sensitive data)

**Function**: Change default port (`localhost:3000` → another port)

**Practical use**: Avoid conflicts when running multiple apps locally (e.g., Python backend on port 3000 + React on 7000)

**Method**: Modify `port: 7000` in `env.js` → `npm run start`

⚠️ For the course: DO NOT change - port 3000 works perfectly.

**Concept**: Files starting with `.` = hidden, files ending with `rc` = configuration.
